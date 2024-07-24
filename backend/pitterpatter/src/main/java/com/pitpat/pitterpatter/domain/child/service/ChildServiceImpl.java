package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildRequestDTO;
import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.UserEntity;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;

    @Override
    public List<ChildResponseDTO> getChildrenByUserId(Integer userId) {
        List<ChildResponseDTO> childrenByUserId = childRepository.findByUserUserId(userId);
        childExceptionHandling(childrenByUserId);
        return childrenByUserId;
    }

    @Override
    public void addChild(ChildRequestDTO childRequestDTO) {
        // TODO : 유저 정보 가져오는 로직 필요
        UserEntity user = new UserEntity();
        user.setUserId(1); // 테스트용 데이터

        // TODO : user가 없는 경우에 대한 예외처리 : user도메인 개발 완료 시 추가.(ForeignKeyConstraintException)
        userExceptionHandling(user);

        Child child = Child.builder()
                .profileImage(childRequestDTO.getProfileImage())
                .user(user)
                .nickname(childRequestDTO.getNickname())
                .gender(childRequestDTO.getGender())
                .birth(childRequestDTO.getBirth())
                .build();

        childRepository.save(child);
    }

    @Override
    public ChildResponseDTO getChildById(Long childId) {
        return childRepository.findById(childId)
                .map(child -> new ChildResponseDTO(
                        child.getId(),
                        child.getProfileImage(),
                        child.getNickname(),
                        child.getGender(),
                        child.getBirth(),
                        child.getPersonalRecord(),
                        child.getPoint(),
                        child.getCreatedAt(),
                        child.getUpdatedAt()))
                .orElseThrow(() -> new DataNotFoundException("Child not found with ID: " + childId));
    }

    /**
     *
     * Exception 검증 메소드
     */
    public void childExceptionHandling(List<ChildResponseDTO> children) {
        // TODO: 유저 토큰 기능 개발 완료 시 해당 예외처리 체크 필요.
        // 토큰/세션 만료 등의 검사가 필요할 경우
        // if (토큰 만료 조건) {
        //     throw new TokenExpiredException("로그인 토큰/세션이 만료되었습니다.");
        // }

        if (children.isEmpty()) {
            throw new DataNotFoundException("해당 데이터가 존재하지 않습니다.");
        }
    }

    @Override
    public void userExceptionHandling(UserEntity user) {

    }

}
