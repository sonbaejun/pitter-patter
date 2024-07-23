package com.pitpat.pitterpatter.domain.assets.repository.pointrecord;

import com.pitpat.pitterpatter.entity.PointRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRecordRepository extends JpaRepository<PointRecord, Long>, PointRecordRepositoryCustom {
}
