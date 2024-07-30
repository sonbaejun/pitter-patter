package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.jwt.JwtTokenProvider;
import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;
import com.pitpat.pitterpatter.domain.user.model.dto.SignUpDto;
import com.pitpat.pitterpatter.domain.user.model.dto.UpdateUserDto;
import com.pitpat.pitterpatter.domain.user.model.dto.UserDto;
import com.pitpat.pitterpatter.domain.user.repository.UserRepository;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.global.exception.user.DuplicateResourceException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

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
    public UserDto emailSignUp(SignUpDto signUpDto) throws DuplicateResourceException {
        // 백에서 이메일, 팀이름 중복체크를 한번 더 해준다
        isEmailAlreadyInUse(signUpDto.getEmail());
        isTeamNameAlreadyInUse(signUpDto.getTeamName());

        // Password 암호화
        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());
        String encoded2Fa = passwordEncoder.encode(signUpDto.getTwoFa());

        // DB에 유저 정보를 저장하고 UserDto로 변환하여 return
        return UserDto.toDto(userRepository.save(signUpDto.toEntity(encodedPassword, encoded2Fa)));
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
        return userRepository.findByUserId(userId)
                .map(UserDto::toDto) // UserEntity를 UserDto로 변경
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }

    // jwt 토큰에서 userId 값을 꺼내와 회원정보 변경
    @Transactional
    @Override
    public UserDto updateUserById(int userId, UpdateUserDto updatedUser) {
        Optional<UserEntity> existingUserOptional = userRepository.findByUserId(userId);
        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();

            if (updatedUser.getTeamName() != null) {
                // 백에서 한번 더 팀 이름 중복 체크
                isTeamNameAlreadyInUse(updatedUser.getTeamName());
                existingUser.setTeamName(updatedUser.getTeamName());
            }
            if (updatedUser.getTwoFa() != null) {
                existingUser.setTwoFa(passwordEncoder.encode(updatedUser.getTwoFa()));
            }
            return UserDto.toDto(userRepository.save(existingUser));
        } else {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }
    }
}
