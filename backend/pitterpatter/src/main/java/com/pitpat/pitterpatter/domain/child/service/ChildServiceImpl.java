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
                .orElseThrow(() -> new DataNotFoundException("해당 데이터가 존재하지 않습니다."));
    }

    @Override
    public void updateChild(Long childId, ChildRequestDTO childRequestDTO) {
        // 자녀 존재여부 검증 후 존재한다면 Child 할당
        Child child = validateChildExists(childId);

        // TODO : user가 없는 경우에 대한 예외처리 : user도메인 개발 완료 시 추가.(ForeignKeyConstraintException)
        userExceptionHandling(child.getUser());

        Child updatedChild = Child.builder()
                .id(childId)
                .profileImage(Optional.ofNullable(childRequestDTO.getProfileImage()).orElse(child.getProfileImage()))
                .nickname(Optional.ofNullable(childRequestDTO.getNickname()).orElse(child.getNickname()))
                .gender(Optional.ofNullable(childRequestDTO.getGender()).orElse(child.getGender()))
                .birth(Optional.ofNullable(childRequestDTO.getBirth()).orElse(child.getBirth()))
                .createdAt(child.getCreatedAt())
                .build();

        childRepository.save(updatedChild);
    }

    @Override
    public void deleteChild(Long childId) {
        // 자녀 존재여부 검증 후 존재한다면 Child 할당
        Child child = validateChildExists(childId);

        childRepository.delete(child);
    }

    /**
     *
     * Exception 검증 메소드
     */
    public void childExceptionHandling(List<ChildResponseDTO> children) {
        if (children.isEmpty()) {
            throw new DataNotFoundException("해당 데이터가 존재하지 않습니다.");
        }
    }

    @Override
    public void userExceptionHandling(UserEntity user) {

    }

    // 해당 ID의 자녀가 존재하는지 검증
    private Child validateChildExists(Long childId) {
        return childRepository.findById(childId)
                .orElseThrow(() -> new DataNotFoundException("해당 자녀가 존재하지 않습니다."));
    }
}
