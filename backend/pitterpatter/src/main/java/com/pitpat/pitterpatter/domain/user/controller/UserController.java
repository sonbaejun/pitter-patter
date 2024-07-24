package com.pitpat.pitterpatter.domain.user.controller;

import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;
import com.pitpat.pitterpatter.domain.user.model.dto.LoginDto;
import com.pitpat.pitterpatter.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // =================== 로그인 관련 ===========================
    // email 유저 로그인 메서드
    @PostMapping("/email")
    public JwtTokenDto emailLogin(@RequestBody LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        JwtTokenDto jwtToken = userService.emailLogin(email, password);
        log.info("request email = {}, password = {}", email, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return jwtToken;
    }

    // TODO: 테스트 완료되면 추후 지울 것
    @GetMapping("/test")
    public String test() {
        return "success";
    }
}

