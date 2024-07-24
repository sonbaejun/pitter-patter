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
        Integer userId = 1; // Test용 데이터
        List<ChildResponseDTO> childrenByUserId = childService.getChildrenByUserId(userId);
        return new ResponseEntity<>(childrenByUserId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addChild(@RequestBody ChildRequestDTO childRequestDTO) {
        System.out.println("childRequestDTO = " + childRequestDTO);
        childService.addChild(childRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
