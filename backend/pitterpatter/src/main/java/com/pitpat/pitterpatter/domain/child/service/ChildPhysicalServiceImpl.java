package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalResponseDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildPhysicalRepository;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.entity.PhysicalRecord;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChildPhysicalServiceImpl implements ChildPhysicalService{

    private final ChildRepository childRepository;
    private final ChildPhysicalRepository childPhysicalRepository;

    @Override
    public ChildPhysicalResponseDTO getLatestPhysicalRecord(Long childId) {
        // 자녀 존재여부 검증
        childRepository.findById(childId)
                .orElseThrow(() -> new DataNotFoundException("자녀정보가 존재하지 않습니다."));

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
}
