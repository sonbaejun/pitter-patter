package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalRequestDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalResponseDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalUpdateDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildRequestDTO;
import com.pitpat.pitterpatter.entity.PhysicalRecord;

public interface ChildPhysicalService {
    ChildPhysicalResponseDTO getLatestPhysicalRecord(Long childId);

    void addPhysicalRecord(Long childId, ChildPhysicalRequestDTO childPhysicalRequestDTO);

    void updateChild(Long childId, ChildPhysicalUpdateDTO childPhysicalUpdateDTO);
}
