package com.pitpat.pitterpatter.domain.assets.repository;

import com.pitpat.pitterpatter.entity.PointRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PointRecordRepository extends JpaRepository<PointRecord, Long> {
}
