package com.pitpat.pitterpatter.domain.assets.service.childitem;

import com.pitpat.pitterpatter.domain.assets.model.dto.childitem.FindChildItemDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemDto;
import com.pitpat.pitterpatter.domain.assets.repository.childitem.ChildItemRepository;
import com.pitpat.pitterpatter.entity.ChildItem;
import com.pitpat.pitterpatter.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChildItemService {

    private final ChildItemRepository childItemRepository;

    // 소유 아이템 리스트 조회
    public List<FindChildItemDto> haveItems(@PathVariable("child_id") Long childId) {
        List<ChildItem> childItems = childItemRepository.haveItems(childId);
        if (childItems.isEmpty()) {
            throw new EntityNotFoundException("보유 중인 아이템이 없습니다.");
        }
        return childItems.stream()
                .map(childItem -> new FindChildItemDto(
                        childItem.getId(),
                        childItem.getItem().getItemName(),
                        childItem.getItem().getPhoto(),
                        childItem.getItem().getItemType(),
                        childItem.getItem().getCategory()))
                .collect(Collectors.toList());
    }

    // 착용 아이템 리스트 조회
    public List<FindChildItemDto> isOnItems(@PathVariable("child_id") Long childId) {
        List<ChildItem> childItems = childItemRepository.isOnItems(childId);
        if (childItems.isEmpty()) {
            throw new EntityNotFoundException("착용 중인 아이템이 없습니다.");
        }
        return childItems.stream()
                .map(childItem -> new FindChildItemDto(
                        childItem.getId(),
                        childItem.getItem().getItemName(),
                        childItem.getItem().getPhoto(),
                        childItem.getItem().getItemType(),
                        childItem.getItem().getCategory()))
                .collect(Collectors.toList());
    }

    // 아이템 버리기
    @Transactional
    public ChildItem throwOutItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        ChildItem childItem = childItemRepository.throwOutItem(childId, itemId);
        if (childItem == null) {
            throw new EntityNotFoundException("현재 아이템을 보유하고 있지 않습니다.");
        }
        return childItem;
    }

    // 아이템 구매
    @Transactional
    public Boolean buyItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        Boolean buyItem = childItemRepository.buyItem(childId, itemId);
        if (buyItem == null) {
            throw new EntityNotFoundException("해당 자녀가 없거나 아이템이 없습니다.");
        }
        return buyItem;
    }

    // 아이템 탈착
    @Transactional
    public Boolean toggleItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        Boolean toggleItem = childItemRepository.toggleItem(childId, itemId);
        if (toggleItem == null) {
            throw new EntityNotFoundException("해당 자녀가 아이템을 보유하고 있지 않습니다.");
        }
        return toggleItem;
    }
}
