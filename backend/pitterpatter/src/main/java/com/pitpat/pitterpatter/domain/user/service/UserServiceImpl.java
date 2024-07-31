package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.jwt.JwtTokenProvider;
import com.pitpat.pitterpatter.domain.user.model.dto.*;
import com.pitpat.pitterpatter.domain.user.repository.UserRepository;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.global.exception.user.DuplicateResourceException;
import com.pitpat.pitterpatter.global.util.user.TeamNameGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Value("${custom.random-2fa}")
    private String random2Fa;

    // ============================= 로그인 관련 ================================
    // TODO: 로그인은 추후 Spring Security Filter로 구현하기
    // (인증 로직을 보안 필터로 분리하여 책임을 명확히. 보안 필터를 통해 모든 요청을 통합적으로 처리할 수 있어, 보안 취약점을 최소화.)
    // email 유저 로그인
    @Transactional
    @Override
    public JwtTokenDto emailLogin(String email, String password) {

        // 1. `email + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication 은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 User 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        JwtTokenDto jwtToken = jwtTokenProvider.generateToken(authentication);

        return jwtToken;
    }

    // ============================= 회원가입 관련 ================================
    // email 유저 회원가입
    @Transactional
    @Override
    public UserDto emailSignUp(EmailUserSignUpDto emailUserSignUpDto) throws DuplicateResourceException, IllegalArgumentException {
        // 1. 백에서 이메일 중복체크를 한번 더 해준다
        isEmailAlreadyInUse(emailUserSignUpDto.getEmail());

        // 2. UserEntity 생성
        UserEntity userEntity = null;

        // 3. Password 유효성 검사
        String password = emailUserSignUpDto.getPassword();
        String encodedPassword = null;
        // password가 유효하지 않은 경우 IllegalArgumentException 예외 발생
        isValidPassword(password);

        // 4. Password 암호화
        // password가 유효한 경우 password 암호화
        encodedPassword = passwordEncoder.encode(password);

        // 5. emailUserSignUpDto를 UserEntity로 변경하고 2차 비밀번호와 팀 이름을 임의로 넣는다.
        userEntity = emailUserSignUpDto.toEntity(encodedPassword);
        userEntity.setTeamName(getUniqueTeamName());
        userEntity.setTwoFa(passwordEncoder.encode(random2Fa));

        // 6. DB에 유저 정보를 저장하고 UserDto로 변환하여 return
        return UserDto.toDto(userRepository.save(userEntity));
    }

    // email 유저 이메일 중복 체크
    @Transactional
    @Override
    public boolean isEmailAlreadyInUse(String email) {
        if (userRepository.existsByEmail(email)) {
            log.error("DuplicateResourceException: Duplicate email sign-up attempt with email: {}", email);
            throw new DuplicateResourceException("This email address is already registered.");
        }
        return false;
    }

    // email, social 유저 팀 이름 중복 체크
    @Transactional
    @Override
    public boolean isTeamNameAlreadyInUse(String teamName) {
        if (userRepository.existsByTeamName(teamName)) {
            log.error("DuplicateResourceException: Duplicate team name sign-up attempt with team name: {}", teamName);
            throw new DuplicateResourceException("This team name is already in use.");
        }
        return false;
    }

    // ====================== 조회, 변경, 탈퇴 ==========================
    // jwt 토큰에서 userId 값을 꺼내와 회원정보 조회
    @Transactional
    @Override
    public UserDto getUserById(int userId) {
        // 1. userId에 해당하는 유저가 DB에 있는 지 확인
        Optional<UserEntity> existingUserOptional = userRepository.findByUserId(userId);

        // 2. DB에 유저가 존재한다면 UserDto로 변환 후 return
        if (existingUserOptional.isPresent()) {
            return UserDto.toDto(existingUserOptional.get());
        }
        // 3. DB에 유저가 존재하지 않는다면 예외 발생
        else {
            log.error("NoSuchElementException: User not found with id: {}", userId);
            throw new NoSuchElementException("User not found");
        }
    }

    // jwt 토큰에서 userId 값을 꺼내와 회원정보 변경
    @Transactional
    @Override
    public UserDto updateUserById(int userId, AdditionalUserInfoDto updatedUser) throws DuplicateResourceException, IllegalArgumentException, NoSuchElementException {
        // 1. userId에 해당하는 유저를 DB에서 가져옴
        // userId에 해당하는 유저가 없을 경우 NoSuchElementException 발생
        UserEntity existingUser = this.getUserById(userId).toEntity();

        // 2. 팀 이름 유효성 검사
        if (updatedUser.getTeamName() != null) {
            // 백에서 한번 더 팀 이름 중복 체크
            // 팀 이름이 중복 될 경우 DuplicateResourceException 예외 발생
            isTeamNameAlreadyInUse(updatedUser.getTeamName());
            existingUser.setTeamName(updatedUser.getTeamName());
        }

        // 3. 2차 비밀번호 유효성 검사
        // 2차 비밀번호가 유효하지 않을 경우 IllegalArgumentException 발생
        isValidPassword(updatedUser.getTwoFa());

        // 4. 2차 비밀번호가 유효할 경우 UsetEntity 업데이트
        existingUser.setTwoFa(passwordEncoder.encode(updatedUser.getTwoFa()));

        // 5. 업데이트된 유저 정보를 DB에 저장 후 UserDto 형태로 변환하여 return
        return UserDto.toDto(userRepository.save(existingUser));
    }

    // jwt 토큰에서 userId 값을 꺼내와 비밀번호 재설정
    @Override
    @Transactional
    public void resetPassword(int userId, PasswordDto passwordDto) throws IllegalArgumentException, NoSuchElementException {
        // 1. userId에 해당하는 유저를 DB에서 가져옴
        // userId에 해당하는 유저가 없을 경우 NoSuchElementException 발생
        UserEntity existingUser = this.getUserById(userId).toEntity();

        // 2. password가 유효한 지 확인
        // 비밀번호가 유효하지 않을 경우 IllegalArgumentException 발생
        String password = passwordDto.getPassword();
        System.out.println("UserSersviceImpl: " + password);
        isValidPassword(password);

        // 3. password가 유효한 경우 UserEntity에 비밀번호 업데이트
        existingUser.setPassword(passwordEncoder.encode(password));

        // 4. DB에 저장
        userRepository.save(existingUser);
    }


    // ====================== 기타 ============================
    // TODO: CustomOAuth2UserService에도 getUniqueTeamName()이 있으므로 따로 빼서 사용하기
    // 팀 이름 생성기를 이용하여 db에 없는 유니크한 팀 이름 반환
    @Override
    @Transactional
    public String getUniqueTeamName() {
        String teamName = null;
        do {
            teamName = TeamNameGenerator.generateTeamName();
        } while(userRepository.existsByTeamName(teamName));
        return teamName;
    }

    // TODO: 좀 더 디테일하게 구현하기
    // 입력으로 들어온 password가 유효한 지 한번 더 확인
    private void isValidPassword(String password) {
        if (password == null || password.trim().equals("")) {
            log.error("IllegalArgumentException: Password is invalid: {}", password);
            throw new IllegalArgumentException("This password is invalid");
        }
    }
}
