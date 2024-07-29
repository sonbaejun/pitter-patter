package com.pitpat.pitterpatter.domain.child.service;

import java.time.LocalDate;
import java.util.List;

public interface PlayHistoryService {
    List<LocalDate> getCurrentMonthPlayData(Long childId);
}
