package com.pitpat.pitterpatter.domain.assets.service.childitem;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemDto;
import com.pitpat.pitterpatter.domain.assets.repository.childitem.ChildItemRepository;
import com.pitpat.pitterpatter.entity.ChildItem;
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
    public List<FindItemDto> haveItems(@PathVariable("child_id") Long childId) {
        List<ChildItem> childItems = childItemRepository.haveItems(childId);
        return childItems.stream()
                .map(childItem -> new FindItemDto(
                        childItem.getItem().getItemName(),
                        childItem.getItem().getPhoto(),
                        childItem.getItem().getItemType(),
                        childItem.getItem().getCategory()))
                .collect(Collectors.toList());
    }

    // 착용 아이템 리스트 조회
    public List<FindItemDto> isOnItems(@PathVariable("child_id") Long childId) {
        List<ChildItem> childItems = childItemRepository.isOnItems(childId);
        return childItems.stream()
                .map(childItem -> new FindItemDto(
                        childItem.getItem().getItemName(),
                        childItem.getItem().getPhoto(),
                        childItem.getItem().getItemType(),
                        childItem.getItem().getCategory()))
                .collect(Collectors.toList());
    }

    // 아이템 버리기
    @Transactional
    public ChildItem throwOutItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemRepository.throwOutItem(childId, itemId);
    }

    // 아이템 구매
    @Transactional
    public boolean buyItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemRepository.buyItem(childId, itemId);
    }

    // 아이템 탈착
    @Transactional
    public boolean toggleItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemRepository.toggleItem(childId, itemId);
    }
}
