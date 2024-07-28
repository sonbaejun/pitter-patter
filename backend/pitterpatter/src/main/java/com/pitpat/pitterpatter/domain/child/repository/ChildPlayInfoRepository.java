package com.pitpat.pitterpatter.domain.child.repository;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPlayInfoResponseDTO;
import com.pitpat.pitterpatter.entity.PlayRecord;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ChildPlayInfoRepository extends JpaRepository<PlayRecord, Long> {
    @Query("SELECT pr FROM PlayRecord pr JOIN FETCH pr.child c WHERE c.id = :childId AND pr.createdAt BETWEEN :startDate AND :endDate")
    List<PlayRecord> findPlayRecordsByDateRangeWithFetchJoin(@Param("childId") Long childId,
                                                             @Param("startDate") LocalDateTime startDate,
                                                             @Param("endDate") LocalDateTime endDate);
}
