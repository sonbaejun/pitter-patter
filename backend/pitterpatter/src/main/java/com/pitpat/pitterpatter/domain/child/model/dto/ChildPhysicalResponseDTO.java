package com.pitpat.pitterpatter.domain.child.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChildPhysicalResponseDTO {

    @NotNull
    private Long id;
    private Float height;
    private Float weight;
    private Float bmi;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    @Builder
    public ChildPhysicalResponseDTO(Long id, Float height, Float weight, Float bmi, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
