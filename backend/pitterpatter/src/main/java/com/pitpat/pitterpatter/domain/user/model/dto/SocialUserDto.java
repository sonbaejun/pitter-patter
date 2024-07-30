package com.pitpat.pitterpatter.domain.user.model.dto;

import com.pitpat.pitterpatter.entity.enums.SocialType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialUserDto {

    private int userId;
    private String serial;
    private SocialType type;
}
