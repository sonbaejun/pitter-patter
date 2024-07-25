package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.model.dto.*;
import com.pitpat.pitterpatter.domain.child.service.ChildPhysicalService;
import com.pitpat.pitterpatter.domain.child.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class ChildPhysicalController {

    private final ChildPhysicalService childPhysicalService;

    @GetMapping("/{childId}/physical")
    public ResponseEntity<ChildPhysicalResponseDTO> getLatestPhysicalRecord(@PathVariable Long childId) {
        ChildPhysicalResponseDTO latestPhysicalRecord = childPhysicalService.getLatestPhysicalRecord(childId);
        return new ResponseEntity<>(latestPhysicalRecord, HttpStatus.OK);
    }

    @PostMapping("/{childId}/physical")
    public ResponseEntity<Void> addPhysicalRecord(@PathVariable Long childId, @RequestBody ChildPhysicalRequestDTO childPhysicalRequestDTO) {
        childPhysicalService.addPhysicalRecord(childId, childPhysicalRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
