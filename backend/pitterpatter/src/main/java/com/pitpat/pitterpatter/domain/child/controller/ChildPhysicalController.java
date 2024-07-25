package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPhysicalResponseDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.service.ChildPhysicalService;
import com.pitpat.pitterpatter.domain.child.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class ChildPhysicalController {

    private final ChildPhysicalService childPhysicalService;

    @GetMapping(value = "/{childId}/physical", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChildPhysicalResponseDTO> getLatestPhysicalRecord(@PathVariable Long childId) {
        ChildPhysicalResponseDTO latestPhysicalRecord = childPhysicalService.getLatestPhysicalRecord(childId);
        return new ResponseEntity<>(latestPhysicalRecord, HttpStatus.OK);
    }
}
