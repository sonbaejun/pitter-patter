package com.pitpat.pitterpatter.domain.child.service;

import com.pitpat.pitterpatter.domain.child.model.dto.ChildResponseDTO;
import com.pitpat.pitterpatter.entity.Child;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChildService {
    List<ChildResponseDTO> getChildrenByUserId(Integer userId);
}
