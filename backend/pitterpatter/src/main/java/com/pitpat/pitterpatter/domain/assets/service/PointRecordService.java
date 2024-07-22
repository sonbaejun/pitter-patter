package com.pitpat.pitterpatter.domain.assets.service;

import com.pitpat.pitterpatter.domain.assets.repository.PointRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PointRecordService {

    private final PointRecordRepository pointRecordRepository;



}
