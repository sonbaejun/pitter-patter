package com.pitpat.pitterpatter.domain.child.model.dto;

import com.pitpat.pitterpatter.entity.PhysicalRecord;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
public class ChildPhysicalUpdateDTO {
    @NotNull
    private Long id;
    private Float height;
    private Float weight;
    private Float bmi;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;


    public PhysicalRecord toUpdateEntity(ChildPhysicalUpdateDTO childPhysicalUpdateDTO, PhysicalRecord physicalRecord, Float caculatedBMI) {
        return PhysicalRecord.builder()
                .id(childPhysicalUpdateDTO.getId())
                .height(Optional.ofNullable(childPhysicalUpdateDTO.getHeight()).orElse(physicalRecord.getHeight()))
                .weight(Optional.ofNullable(childPhysicalUpdateDTO.getWeight()).orElse(physicalRecord.getWeight()))
                .bmi(caculatedBMI)
                .createdAt(physicalRecord.getCreatedAt())
                .child(physicalRecord.getChild())
                .build();
    }
}
