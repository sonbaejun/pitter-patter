package com.pitpat.pitterpatter.domain.user.model.dto;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.entity.enums.SocialType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class SignUpDto {

    private String twoFa;
    private Boolean isSocial;
    private String teamName;
    private String email;
    private String password;
    // only social user
    private String serial;
    // only social user
    private SocialType type;
    private List<Child> children;

    public UserEntity toEntity(String encodedPassword, String encoded2Fa) {
        return UserEntity.builder()
                .twoFa(encoded2Fa)
                .isSocial(isSocial)
                .teamName(teamName)
                .email(email)
                .password(encodedPassword)
                .serial(serial)
                .type(type)
                .children(children)
                .build();
    }
}
