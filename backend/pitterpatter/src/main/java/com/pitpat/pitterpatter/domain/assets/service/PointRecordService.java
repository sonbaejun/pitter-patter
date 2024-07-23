package com.pitpat.pitterpatter.domain.assets.service;

import com.pitpat.pitterpatter.domain.assets.repository.PointRecordRepository;
import com.pitpat.pitterpatter.entity.PointRecord;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PointRecordService {

    private final PointRecordRepository pointRecordRepository;
    private final EntityManager em;


}
