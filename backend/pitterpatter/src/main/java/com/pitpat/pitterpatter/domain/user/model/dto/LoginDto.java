package com.pitpat.pitterpatter.domain.user.model.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@ToString
@AllArgsConstructor
public class LoginDto {
    private String email;
    private String password;
}
