package com.pitpat.pitterpatter.domain.assets.controller.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.CreatePointRecordDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.FindPointRecordDto;
import com.pitpat.pitterpatter.domain.assets.service.pointrecord.PointRecordService;
import com.pitpat.pitterpatter.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
@Slf4j
public class PointRecordController {

    private final PointRecordService pointRecordService;

    @PatchMapping("/point/{child_id}")
    public ResponseEntity<?> createPointRecord(@RequestBody CreatePointRecordDto createPointRecordDto) {
        try {
            log.info("createDto = {}", createPointRecordDto);
            FindPointRecordDto createdRecord = pointRecordService.createPointRecord(createPointRecordDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("포인트 레코드 생성 실패: " + e.getMessage());
        }
    }

    // 아이별 포인트 조회
    @GetMapping("/point/{child_id}")
    public ResponseEntity<?> findByPointByChild(@PathVariable("child_id") Long childId) {
        try {
            Integer points = pointRecordService.findPointByChild(childId);
            return ResponseEntity.ok(points);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("포인트 조회 실패: " + e.getMessage());
        }
    }

    // 아이별 포인트 기록 조회
    @GetMapping("/point-record/{child_id}")
    public ResponseEntity<?> findPointRecordsByChild(@PathVariable("child_id") Long childId) {
        try {
            List<FindPointRecordDto> pointRecords = pointRecordService.findPointRecordsByChild(childId);
            return ResponseEntity.ok(pointRecords);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("포인트 기록 조회 실패: " + e.getMessage());
        }
    }
}
