package com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FindPointRecordDto {
    private int amount;
    private String source;
    private LocalDateTime created_at;

    public FindPointRecordDto(int amount, String source, LocalDateTime created_at) {
        this.amount = amount;
        this.source = source;
        this.created_at = created_at;
    }
}
