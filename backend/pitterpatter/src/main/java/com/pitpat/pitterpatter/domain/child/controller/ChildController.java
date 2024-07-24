package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildRequestDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.domain.child.service.ChildService;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import com.pitpat.pitterpatter.global.exception.exceptions.TokenExpiredException;
import com.pitpat.pitterpatter.global.exception.exceptions.UserProblemException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping
    public ResponseEntity<List<ChildResponseDTO>> getChildrenList() {
        // Test용 데이터
        Integer userId = 1;
        List<ChildResponseDTO> childrenByUserId = childService.getChildrenByUserId(userId);
        return new ResponseEntity<>(childrenByUserId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addChild(@RequestBody ChildRequestDTO childRequestDTO) {
        childService.addChild(childRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{childId}")
    public ResponseEntity<ChildResponseDTO> getChildById(@PathVariable Long childId) {
        ChildResponseDTO childResponseDTO = childService.getChildById(childId);
        return new ResponseEntity<>(childResponseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{childId}")
    public ResponseEntity<Void> updateChild(@PathVariable Long childId, @RequestBody ChildRequestDTO childRequestDTO) {
        childService.updateChild(childId, childRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
