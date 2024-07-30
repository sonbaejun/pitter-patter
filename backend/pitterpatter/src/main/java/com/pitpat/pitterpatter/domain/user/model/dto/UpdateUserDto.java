package com.pitpat.pitterpatter.domain.user.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateUserDto {

    private String twoFa;
    private String teamName;
}
