package com.pitpat.pitterpatter.domain.assets.repository;

import com.pitpat.pitterpatter.entity.PointRecord;

import java.util.List;

public interface PointRecordRepositoryCustom {

    List<PointRecord> useOrEarnPoint(int amount, Long childId);
    int findPointByChild(Long childId);
    List<PointRecord> findRecordsByChild(Long childId);



}
