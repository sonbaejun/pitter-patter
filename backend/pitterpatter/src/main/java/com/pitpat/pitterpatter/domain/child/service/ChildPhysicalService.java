package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalResponseDTO;
import com.pitpat.pitterpatter.entity.PhysicalRecord;

public interface ChildPhysicalService {
    ChildPhysicalResponseDTO getLatestPhysicalRecord(Long childId);
}
