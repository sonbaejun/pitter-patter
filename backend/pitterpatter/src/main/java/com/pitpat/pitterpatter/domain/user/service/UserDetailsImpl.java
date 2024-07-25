package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.entity.UserEntity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    // TODO: UserEntity를 직접적으로 사용하는 것은 위험하므로, UserDto로 바꾸기
    private final UserEntity user;

    // 생성자
    public UserDetailsImpl(UserEntity user) {
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
