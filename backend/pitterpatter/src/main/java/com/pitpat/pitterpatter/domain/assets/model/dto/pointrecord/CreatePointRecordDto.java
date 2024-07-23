package com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord;

import com.pitpat.pitterpatter.entity.Child;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePointRecordDto {
    @NotNull
    private int amount;
    @NotNull
    private String source;
    @NotNull
    private Child child;

    public CreatePointRecordDto(int amount, String source, Child child) {
        this.amount = amount;
        this.source = source;
        this.child = child;
    }
}
