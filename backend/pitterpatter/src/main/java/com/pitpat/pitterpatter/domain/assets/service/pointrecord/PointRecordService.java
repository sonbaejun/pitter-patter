package com.pitpat.pitterpatter.domain.assets.service.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.item.ItemSearchCondition;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.repository.pointrecord.PointRecordRepository;
import com.pitpat.pitterpatter.entity.PointRecord;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PointRecordService {

    private final PointRecordRepository pointRecordRepository;
    private final EntityManager em;

    public PointRecord createPointRecord(CreatePointRecordDto createPointRecordDto) {
        PointRecord pointRecord = new PointRecord(createPointRecordDto.getAmount(),
                createPointRecordDto.getSource(),
                createPointRecordDto.getChild());
        return pointRecordRepository.save(pointRecord);
    }

}
