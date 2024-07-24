package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;

public interface UserService {

    // email 사용자 로그인 메서드
    public JwtTokenDto emailLogin(String email, String password);
}
