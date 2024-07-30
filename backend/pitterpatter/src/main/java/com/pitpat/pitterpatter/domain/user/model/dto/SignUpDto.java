package com.pitpat.pitterpatter.domain.user.model.dto;

import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.entity.enums.SocialType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class SignUpDto {

    private String twoFa;
    private Boolean isSocial;
    private String email;
    private String password;
    private String teamName;
    // only social user
    private String serial;
    // only social user
    private SocialType type;

    public UserEntity toEntity(String encodedPassword, String encoded2Fa) {
        return UserEntity.builder()
                .twoFa(encoded2Fa)
                .isSocial(isSocial)
                .email(email)
                .password(encodedPassword)
                .teamName(teamName)
                .serial(serial)
                .type(type)
                .build();
    }
}
