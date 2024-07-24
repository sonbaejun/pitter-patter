package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;

public interface UserService {

    // ===================== 로그인 관련 ==========================
    // email 유저 로그인
    public JwtTokenDto emailLogin(String email, String password);
}
