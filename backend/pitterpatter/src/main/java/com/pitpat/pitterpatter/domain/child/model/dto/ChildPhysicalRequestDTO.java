package com.pitpat.pitterpatter.domain.child.model.dto;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PhysicalRecord;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChildPhysicalRequestDTO {

    private Float height;
    private Float weight;
    private Float bmi;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    public PhysicalRecord toAddEntity(Child child, ChildPhysicalRequestDTO childPhysicalRequestDTO, Float caculatedBMI) {
        return PhysicalRecord.builder()
                .child(child)
                .height(childPhysicalRequestDTO.getHeight())
                .weight(childPhysicalRequestDTO.getWeight())
                .bmi(caculatedBMI)
                .build();
    }
}
