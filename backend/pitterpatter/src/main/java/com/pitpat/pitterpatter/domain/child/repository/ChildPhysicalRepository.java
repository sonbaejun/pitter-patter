package com.pitpat.pitterpatter.domain.child.repository;

import com.pitpat.pitterpatter.entity.PhysicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildPhysicalRepository extends JpaRepository<PhysicalRecord, Long> {
    Optional<PhysicalRecord> findTopByChildIdOrderByUpdatedAtDesc(Long childId);
}
