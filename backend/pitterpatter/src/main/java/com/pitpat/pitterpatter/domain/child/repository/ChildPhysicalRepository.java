package com.pitpat.pitterpatter.domain.child.repository;

import com.pitpat.pitterpatter.entity.PhysicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildPhysicalRepository extends JpaRepository<PhysicalRecord, Long> {
    Optional<PhysicalRecord> findTopByChildIdOrderByUpdatedAtDesc(Long childId);
}
