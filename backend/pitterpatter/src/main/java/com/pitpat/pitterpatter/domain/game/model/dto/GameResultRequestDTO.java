package com.pitpat.pitterpatter.domain.game.model.dto;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PlayRecord;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GameResultRequestDTO {

    @NotNull
    private Integer score;
    @NotNull
    private Integer playtime;
    @NotNull
    private Integer burnedCalorie;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    public PlayRecord toAddEntity(Child child, GameResultRequestDTO gameResultRequestDTO) {
        return PlayRecord.builder()
                .child(child)
                .score(score)
                .playtime(playtime)
                .burnedCalorie(burnedCalorie)
                .build();
    }
}
