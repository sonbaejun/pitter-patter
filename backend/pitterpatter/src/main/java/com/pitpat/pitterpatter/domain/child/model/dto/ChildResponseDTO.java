package com.pitpat.pitterpatter.domain.child.model.dto;

import com.pitpat.pitterpatter.entity.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ChildResponseDTO {
    @NotNull
    private Long id;
    private String profileImage;
    @NotNull
    private String nickname;
    @NotNull
    private Gender gender;
    @NotNull
    private LocalDate birth;
    private int personalRecord;
    private int point;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;
}


