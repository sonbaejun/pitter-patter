package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.entity.UserEntity;
import io.jsonwebtoken.security.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Collections;

@Builder
public class CustomUserDetails implements UserDetails {

    private final UserEntity user;

    // 생성자
    public CustomUserDetails(UserEntity user) {
        this.user = user;
    }

    // 권한을 반환하는 메서드
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 빈 리스트 반환 (USER, ADMIN과 같은 권한 체계 없음)
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
