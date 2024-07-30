package com.pitpat.pitterpatter.domain.user.model.dto;

import com.pitpat.pitterpatter.entity.UserEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class EmailUserSignUpDto extends LoginDto {

    private Boolean isSocial;

    public UserEntity toEntity(String encodedPassword) {
        return UserEntity.builder()
                .isSocial(isSocial)
                .email(super.getEmail())
                .password(encodedPassword)
                .build();
    }
}
