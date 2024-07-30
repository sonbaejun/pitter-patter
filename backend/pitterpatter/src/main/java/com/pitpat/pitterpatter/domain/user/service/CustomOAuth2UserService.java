package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.*;
import com.pitpat.pitterpatter.domain.user.repository.UserRepository;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.entity.enums.SocialType;
import com.pitpat.pitterpatter.global.util.user.TeamNameGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Value("${custom.random-2fa}")
    private String random2Fa;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("kakao")) {
            oAuth2Response = new KakaoResponseDto(oAuth2User.getAttributes());
        }
        else {
            return null;
        }

        String serial = oAuth2Response.getProvider() + oAuth2Response.getProviderId();
        Optional<UserEntity> existingUser = userRepository.findBySerial(serial);
        int userId = -1;
        // DB에 유저가 존재하지 않는 경우 새로 entity를 만들어서 DB에 저장 후 userId 값을 꺼내옴
        if (!existingUser.isPresent()) {
            userId = saveUserEntity(oAuth2Response, serial);
        }
        // DB에 유저가 존재하는 경우 userId 값을 꺼내옴
        else {
            userId = existingUser.get().getUserId();
        }

        return makeCustomOAuth2UserDto(oAuth2Response, serial, userId);
    }

    private int saveUserEntity(OAuth2Response oAuth2Response, String serial) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();

        userEntity.setIsSocial(true);
        // 임시 2차 비밀번호 저장
        userEntity.setTwoFa(passwordEncoder.encode(random2Fa));
        // 팀 이름 랜덤 생성기를 이용하여 팀 이름 생성
        userEntity.setTeamName(generateTeamName());
        userEntity.setSerial(serial);
        userEntity.setType(SocialType.valueOf(oAuth2Response.getProvider().toString()));

        return UserDto.toDto(userRepository.save(userEntity)).getUserId();
    }

    private CustomOAuth2UserDto makeCustomOAuth2UserDto(OAuth2Response oAuth2Response, String serial, int userId) {
        SocialUserDto socialUserDto = new SocialUserDto();

        socialUserDto.setType(SocialType.valueOf(oAuth2Response.getProvider().toString()));
        socialUserDto.setSerial(serial);
        socialUserDto.setUserId(userId);

        return new CustomOAuth2UserDto(socialUserDto);
    }

    private String generateTeamName() {
        String teamName = null;
        do {
            teamName = TeamNameGenerator.generateTeamName();
        } while(userRepository.existsByTeamName(teamName));
        return teamName;
    }
}
