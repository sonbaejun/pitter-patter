package com.pitpat.pitterpatter.domain.user.controller;

import com.pitpat.pitterpatter.domain.user.model.dto.JwtTokenDto;
import com.pitpat.pitterpatter.domain.user.model.dto.LoginDto;
import com.pitpat.pitterpatter.domain.user.model.dto.SignUpDto;
import com.pitpat.pitterpatter.domain.user.model.dto.UserDto;
import com.pitpat.pitterpatter.domain.user.service.UserDetailsImpl;
import com.pitpat.pitterpatter.domain.user.service.UserService;
import com.pitpat.pitterpatter.global.exception.DuplicateResourceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // =================== 로그인 관련 ===========================
    // email 유저 로그인 메서드
    @PostMapping("/login/email")
    public ResponseEntity<JwtTokenDto> emailLogin(@RequestBody LoginDto loginDto) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        JwtTokenDto jwtToken = userService.emailLogin(email, password);
        log.info("request email = {}, password = {}", email, password);
        log.info("jwtToken accessToken = {}, refreshToken = {}", jwtToken.getAccessToken(), jwtToken.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body(jwtToken);
    }

    // TODO: 테스트 완료되면 추후 지울 것
    @GetMapping("/test")
    public String test() {
        return "success";
    }

    // email 유저 회원가입
    @PostMapping("/email")
    public ResponseEntity<?> emailSignUp(@RequestBody SignUpDto signUpDto) {
        try {
            UserDto savedUserDto = userService.emailSignUp(signUpDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDto);
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // email 유저 이메일 중복 체크
    @GetMapping("/check/email")
    public ResponseEntity<String> isEmailAlreadyInUse(@RequestParam String email) {
        try {
            userService.isEmailAlreadyInUse(email);
            return ResponseEntity.status(HttpStatus.OK).body(email + " is available.");
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // email, social 유저 팀 이름 중복 체크
    @GetMapping("/check/teamname")
    public ResponseEntity<String> isTeamNameAlreadyInUse(@RequestParam(name = "teamname") String teamName) {
        try {
            userService.isTeamNameAlreadyInUse(teamName);
            return ResponseEntity.status(HttpStatus.OK).body(teamName + " is available.");
        } catch (DuplicateResourceException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }



    // ====================== 조회, 변경, 탈퇴 ==========================
    // 회원정보 조회
    @GetMapping
    public ResponseEntity<UserDto> getUserByEmail(@AuthenticationPrincipal UserDetails userDetails) {
        // TODO: exception 처리
        String email = userDetails.getUsername();
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

}

