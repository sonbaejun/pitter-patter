package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;
import com.pitpat.pitterpatter.domain.user.model.dto.SignUpDto;
import com.pitpat.pitterpatter.domain.user.model.dto.UserDto;

public interface UserService {

    // ===================== 로그인 관련 ==========================
    // email 유저 로그인
    public JwtTokenDto emailLogin(String email, String password);

    // ===================== 회원가입 관련 ========================
    // email 유저 회원가입
    public UserDto emailSignUp(SignUpDto signUpDto);
    // email 유저 이메일 중복 체크
    public boolean isEmailAlreadyInUse(String email);
    // email, social 유저 팀 이름 중복 체크
    public boolean isTeamNameAlreadyInUse(String teamName);

    // ====================== 조회, 변경, 탈퇴 ==========================
    // 회원정보 조회
    public UserDto getUserByEmail(String email);
}
