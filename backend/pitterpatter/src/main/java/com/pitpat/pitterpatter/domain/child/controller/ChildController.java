package com.pitpat.pitterpatter.domain.child.controller;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildRequestDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.domain.child.service.ChildService;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import com.pitpat.pitterpatter.global.exception.exceptions.TokenExpiredException;
import com.pitpat.pitterpatter.global.exception.exceptions.UserProblemException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<?> addChild(@Valid @RequestBody ChildRequestDTO childRequestDTO, BindingResult bindingResult) {

        ResponseEntity<List<String>> validatedChildRequest = validateChildRequest(bindingResult);
        if (validatedChildRequest != null) {
            return validatedChildRequest;
        }

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

    @DeleteMapping("/{childId}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long childId) {
        childService.deleteChild(childId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private static ResponseEntity<List<String>> validateChildRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // 유효성 검증 실패 시, 에러 메시지를 담아서 반환
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
