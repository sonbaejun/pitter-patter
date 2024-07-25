package com.pitpat.pitterpatter.domain.child.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChildPhysicalResponseDTO {

    @NotNull
    private Long id;
    private float height;
    private float weight;
    private float bmi;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    @Builder
    public ChildPhysicalResponseDTO(Long id, float height, float weight, float bmi, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
