package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPlayInfoResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ChildPlayInfoService {
    List<ChildPlayInfoResponseDTO> getPlayRecordsByDateRange(Long childId, LocalDateTime startDate, LocalDateTime endDate);
}
