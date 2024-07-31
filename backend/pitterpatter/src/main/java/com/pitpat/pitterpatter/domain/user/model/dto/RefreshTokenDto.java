package com.pitpat.pitterpatter.domain.user.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("RefreshToken")
@AllArgsConstructor
@Getter
@Builder
@Setter
@NoArgsConstructor
public class RefreshTokenDto {
    @Id
    private int userId;
    private String refreshToken;
    
    // @TimeToLive: 자동 삭제 시간
    @TimeToLive
    private Long ttl;
}