package com.pitpat.pitterpatter.domain.assets.service.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.item.ItemSearchCondition;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.FindPointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.PointRecordSearchCondition;
import com.pitpat.pitterpatter.domain.assets.repository.pointrecord.PointRecordRepository;
import com.pitpat.pitterpatter.entity.PointRecord;
import com.pitpat.pitterpatter.entity.QPointRecord;
import com.querydsl.core.types.dsl.BooleanExpression;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.pitpat.pitterpatter.entity.QPointRecord.pointRecord;

@Service
@RequiredArgsConstructor
@Transactional
public class PointRecordService {

    private final PointRecordRepository pointRecordRepository;
    private final EntityManager em;

    // TODO : CHILD 포인트 변경 추가해줘야됌
    // 포인트 레코드 생성
    public PointRecord createPointRecord(CreatePointRecordDto createPointRecordDto) {
        PointRecord pointRecord = new PointRecord(createPointRecordDto.getAmount(),
                createPointRecordDto.getSource(),
                createPointRecordDto.getChild());
        // 포인트 +- 추가해야됨
        return pointRecordRepository.save(pointRecord);
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
                                pr.getCreated_at()))
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
                                pr.getCreated_at()))
                .collect(Collectors.toList());
    }


}
