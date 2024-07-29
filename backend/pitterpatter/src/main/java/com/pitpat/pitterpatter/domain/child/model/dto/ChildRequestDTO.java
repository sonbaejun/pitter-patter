package com.pitpat.pitterpatter.domain.child.model.dto;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.entity.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

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

    public Child toAddEntity(UserEntity user, ChildRequestDTO childRequestDTO) {
        return Child.builder()
                .profileImage(childRequestDTO.getProfileImage())
                .user(user)
                .nickname(childRequestDTO.getNickname())
                .gender(childRequestDTO.getGender())
                .birth(childRequestDTO.getBirth())
                .build();
    }

    public Child toUpdateEntity(Child child, ChildRequestDTO childRequestDTO) {
        return Child.builder()
                .id(child.getId())
                .profileImage(Optional.ofNullable(childRequestDTO.getProfileImage()).orElse(child.getProfileImage()))
                .nickname(Optional.ofNullable(childRequestDTO.getNickname()).orElse(child.getNickname()))
                .gender(Optional.ofNullable(childRequestDTO.getGender()).orElse(child.getGender()))
                .birth(Optional.ofNullable(childRequestDTO.getBirth()).orElse(child.getBirth()))
                .createdAt(child.getCreatedAt())
                .build();
    }
}
