package com.pitpat.pitterpatter.domain.assets.controller.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.FindPointRecordDto;
import com.pitpat.pitterpatter.domain.assets.service.pointrecord.PointRecordService;
import com.pitpat.pitterpatter.entity.PointRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
public class PointRecordController {

    private final PointRecordService pointRecordService;

    @PatchMapping("/point/{child_id}")
    public FindPointRecordDto createPointRecord(@RequestBody CreatePointRecordDto createPointRecordDto) {
        return pointRecordService.createPointRecord(createPointRecordDto);
    }

    // 아이별 포인트 조회
    @GetMapping("/point/{child_id}")
    public Integer findByPointByChild(@PathVariable("child_id") Long childId) {
        return pointRecordService.findPointByChild(childId);
    }

    // 아이별 포인트 기록 조회
    @GetMapping("/point-record/{child_id}")
    public List<FindPointRecordDto> findPointRecordsByChild(@PathVariable("child_id") Long childId) {
        return pointRecordService.findPointRecordsByChild(childId);
    }

}
