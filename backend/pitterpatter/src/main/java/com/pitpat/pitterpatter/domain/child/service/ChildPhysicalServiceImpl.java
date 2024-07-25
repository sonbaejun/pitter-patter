package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.*;
import com.pitpat.pitterpatter.domain.child.repository.ChildPhysicalRepository;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PhysicalRecord;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildPhysicalServiceImpl implements ChildPhysicalService{

    private final ChildRepository childRepository;
    private final ChildPhysicalRepository childPhysicalRepository;

    @Override
    public ChildPhysicalResponseDTO getLatestPhysicalRecord(Long childId) {
        // 자녀 존재여부 검증
        validateChildExists(childId);

        ChildPhysicalResponseDTO childPhysicalResponseDTO = childPhysicalRepository.findTopByChildIdOrderByUpdatedAtDesc(childId)
                .map(childPhysical -> ChildPhysicalResponseDTO.builder()
                        .id(childPhysical.getId())
                        .height(childPhysical.getHeight())
                        .weight(childPhysical.getWeight())
                        .bmi(childPhysical.getBmi())
                        .createdAt(childPhysical.getCreatedAt())
                        .updatedAt(childPhysical.getUpdatedAt())
                        .build())
                .orElseThrow(() -> new DataNotFoundException("자녀의 신체정보가 존재하지 않습니다."));

        return childPhysicalResponseDTO;
    }

    @Override
    public void addPhysicalRecord(Long childId, ChildPhysicalRequestDTO childPhysicalRequestDTO) {
        // 자녀 존재여부 검증 후 존재한다면 Child 할당
        Child child = validateChildExists(childId);

        // 키, 몸무게 기준으로 BMI 계산
        float caculatedBMI = calculateBMI(childPhysicalRequestDTO.getHeight(), childPhysicalRequestDTO.getWeight());

        PhysicalRecord physicalRecord = PhysicalRecord.builder()
                .child(child)
                .height(childPhysicalRequestDTO.getHeight())
                .weight(childPhysicalRequestDTO.getWeight())
                .bmi(caculatedBMI)
                .build();

        childPhysicalRepository.save(physicalRecord);
    }

    // BMI 계산
    private float calculateBMI(float height, float weight) {
        if (height <= 0 || weight <= 0) {
            throw new IllegalArgumentException("키 또는 몸무게가 음수입니다.");
        }
        float caculatedBMI = weight / (height * height);
        caculatedBMI *= 10000;
        caculatedBMI = Math.round(caculatedBMI * 100) / 100.0f;
        return caculatedBMI;
    }

    // 해당 ID의 자녀가 존재하는지 검증
    private Child validateChildExists(Long childId) {
        return childRepository.findById(childId)
                .orElseThrow(() -> new DataNotFoundException("해당 자녀가 존재하지 않습니다."));
    }
}
