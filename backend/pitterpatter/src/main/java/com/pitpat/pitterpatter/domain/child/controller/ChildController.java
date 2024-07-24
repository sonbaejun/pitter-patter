package com.pitpat.pitterpatter.domain.child.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/child")
@RequiredArgsConstructor
public class ChildController {
    private final ChildService childService;

    @GetMapping
    public ResponseEntity<List<ChildResponseDTO>> getChildren() {
        Integer userId = 1; // Test용 데이터
        List<ChildResponseDTO> childrenByUserId = childService.getChildrenByUserId(userId);
        exceptionHandling(childrenByUserId);
        return new ResponseEntity<>(childrenByUserId, HttpStatus.OK);
    }

    /**
     *
     * Exception 검증 메소드
     */
    private void exceptionHandling(List<ChildResponseDTO> children) {
        if (children.isEmpty()) {
            throw new DataNotFoundException("데이터 없음");
        }

        // TODO: 유저 토큰 기능 개발 완료 시 해당 예외처리 체크 필요.
        // 토큰/세션 만료 등의 검사가 필요할 경우
        // if (토큰 만료 조건) {
        //     throw new TokenExpiredException("토큰/세션 만료");
        // }

        // 사용자 문제 발생 시
        // if (사용자 문제 조건) {
        //     throw new UserProblemException("사용자 문제");
        // }
    }
}
