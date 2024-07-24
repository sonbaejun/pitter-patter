package com.pitpat.pitterpatter.domain.child.model.dto;

import com.pitpat.pitterpatter.entity.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ChildRequestDTO {
    private String profileImage;
    @NotNull
    private String nickname;
    @NotNull(message = "유효하지 않은 성별입니다.")
    private Gender gender;
    @NotNull
    private LocalDate birth;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
}
