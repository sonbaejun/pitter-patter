package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.repository.UserRepository;
import com.pitpat.pitterpatter.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    // 이메일로 사용자 엔티티 조회
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }

    // 해당하는 User의 데이터가 존재한다면 CustomUserDetails 객체로 만들어서 return
    private UserDetails createUserDetails(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return CustomUserDetails.builder()
                .user(user)
                .build();
    }

}