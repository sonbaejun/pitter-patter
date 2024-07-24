package com.pitpat.pitterpatter.domain.user.model.dto;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LoginDto {
    private String email;
    private String password;
}
