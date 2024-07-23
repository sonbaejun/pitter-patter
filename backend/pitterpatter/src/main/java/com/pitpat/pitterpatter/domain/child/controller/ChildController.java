package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.domain.child.service.ChildService;
import com.pitpat.pitterpatter.entity.Child;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping
    public List<ChildResponseDTO> getChildren() {
        Integer userId = 1; // Test용 데이터
        return childService.getChildrenByUserId(userId);
    }
}
