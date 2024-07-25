package com.pitpat.pitterpatter.domain.assets.service.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.FindPointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.PointRecordSearchCondition;
import com.pitpat.pitterpatter.domain.assets.repository.pointrecord.PointRecordRepository;
import com.pitpat.pitterpatter.entity.PointRecord;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointRecordService {

    private final PointRecordRepository pointRecordRepository;

    // TODO : CHILD 포인트 변경 추가해줘야됌
    // 포인트 레코드 생성
    @Transactional
    public FindPointRecordDto createPointRecord(CreatePointRecordDto createPointRecordDto) {
        PointRecord pointRecord = pointRecordRepository.savePointRecord(createPointRecordDto);
        return new FindPointRecordDto(
                pointRecord.getAmount(),
                pointRecord.getSource(),
                pointRecord.getCreatedAt());
    }

    // 포인트 조회
    public Integer findPointByChild(Long childId) {
        return pointRecordRepository.findPointByChild(childId);
    }

    // 어린이 계정별 포인트 레코드 조회
    public List<FindPointRecordDto> findPointRecordsByChild(Long childId) {
        List<PointRecord> pointRecords = pointRecordRepository.findRecordsByChild(childId);
        return pointRecords.stream()
                .map((PointRecord pr) ->
                        new FindPointRecordDto(
                                pr.getAmount(),
                                pr.getSource(),
                                pr.getCreatedAt()))
                .collect(Collectors.toList());
    }

    // 여러 검색 조건에 따른 포인트 레코드 조회
    public List<FindPointRecordDto> findPointRecordByConditions(PointRecordSearchCondition condition, Long childId) {
        List<PointRecord> pointRecords = pointRecordRepository.findPointRecordByConditions(condition, childId);

        return pointRecords.stream()
                .map((PointRecord pr) ->
                        new FindPointRecordDto(
                                pr.getAmount(),
                                pr.getSource(),
                                pr.getCreatedAt()))
                .collect(Collectors.toList());
    }


}
