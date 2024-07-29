package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.service.PlayHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class PlayHistoryController {

    private final PlayHistoryService playHistoryService;

    @GetMapping("/{childId}/play-record/attendance")
    public ResponseEntity<List<LocalDate>> getCurrentMonthPlayData(@PathVariable Long childId) {
        List<LocalDate> currentMonthPlayData = playHistoryService.getCurrentMonthPlayData(childId);
        return new ResponseEntity<>(currentMonthPlayData, HttpStatus.OK);
    }
}
