package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.*;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    // ===================== 로그인 관련 ==========================
    // email 유저 로그인
    public JwtTokenDto emailLogin(String email, String password);

    // ===================== 회원가입 관련 ========================
    // email 유저 회원가입
    public UserDto emailSignUp(EmailUserSignUpDto signUpDto);
    // email 유저 이메일 중복 체크
    public boolean isEmailAlreadyInUse(String email);
    // email, social 유저 팀 이름 중복 체크
    public boolean isTeamNameAlreadyInUse(String teamName);

    // ====================== 조회, 변경, 탈퇴 ==========================
    // jwt 토큰에서 userId 값을 꺼내와 회원정보 조회
    public UserDto getUserById(int userId);
    // jwt 토큰에서 userId 값을 꺼내와 회원정보 변경
    public UserDto updateUserById(int userId, AdditionalUserInfoDto updatedUser);
    // jwt 토큰에서 userId 값을 꺼내와 비밀번호 재설정
    public void resetPassword(int userId, PasswordDto passwordDto);

    // ====================== 기타 ============================
    // 팀 이름 생성기를 이용하여 db에 없는 유니크한 팀 이름 반환
    public String getUniqueTeamName();
}
