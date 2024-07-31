package com.pitpat.pitterpatter.domain.user.service;

import com.pitpat.pitterpatter.domain.user.model.dto.RefreshTokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final String REFRESH_TOKEN_KEY_PREFIX = "refreshToken:";

    public void saveRefreshToken(int userId, String refreshToken, Long ttl) {
        redisTemplate.opsForValue().set(REFRESH_TOKEN_KEY_PREFIX + userId, refreshToken, ttl, TimeUnit.MILLISECONDS);
    }

    public RefreshTokenDto getRefreshToken(String userId) {
        return (RefreshTokenDto) redisTemplate.opsForValue().get(REFRESH_TOKEN_KEY_PREFIX + userId);
    }

    public void deleteRefreshToken(String userId) {
        redisTemplate.delete(REFRESH_TOKEN_KEY_PREFIX + userId);
    }
}