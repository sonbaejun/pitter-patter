package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildPlayInfoResponseDTO;
import com.pitpat.pitterpatter.domain.child.repository.ChildPlayInfoRepository;
import com.pitpat.pitterpatter.domain.child.repository.ChildRepository;
import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PlayRecord;
import com.pitpat.pitterpatter.global.exception.exceptions.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChildPlayInfoServiceImpl implements ChildPlayInfoService {

    private final ChildPlayInfoRepository childPlayInfoRepository;
    private final ChildRepository childRepository;

    @Override
    public List<ChildPlayInfoResponseDTO> getPlayRecordsByDateRange(Long childId, LocalDateTime startDate, LocalDateTime endDate) {
        validateChildExists(childId);
        List<PlayRecord> playRecords = childPlayInfoRepository.findPlayRecordsByDateRangeWithFetchJoin(childId, startDate, endDate);
        validateNotEmptyList(playRecords);
        List<ChildPlayInfoResponseDTO> childPlayInfoResponseDTOList = convertPlayRecordToChildPlayInfoResponseDTO(playRecords);

        return childPlayInfoResponseDTOList;
    }

    private List<ChildPlayInfoResponseDTO> convertPlayRecordToChildPlayInfoResponseDTO(List<PlayRecord> playRecords) {
        List<ChildPlayInfoResponseDTO> result = playRecords.stream()
                .collect(Collectors.groupingBy(pr -> pr.getCreatedAt().toLocalDate(), Collectors.summingLong(PlayRecord::getPlaytime)))
                .entrySet().stream()
                .map(entry -> new ChildPlayInfoResponseDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        // 레포지토리에서 역순으로 리턴해주기 때문에, List를 뒤집어서 반환(날짜순 정렬)
        Collections.reverse(result);

        return result;
    }

    private void validateNotEmptyList(List<PlayRecord> playRecordsByDateRange) {
        if(playRecordsByDateRange.isEmpty()) {
            throw new DataNotFoundException("기간에 해당하는 플레이타임 기록이 존재하지 않습니다.");
        }
    }

    // 해당 ID의 자녀가 존재하는지 검증
    private Child validateChildExists(Long childId) {
        return childRepository.findById(childId)
                .orElseThrow(() -> new DataNotFoundException("해당 자녀가 존재하지 않습니다."));
    }
}
