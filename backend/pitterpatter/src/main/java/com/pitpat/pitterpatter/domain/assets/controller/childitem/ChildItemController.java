package com.pitpat.pitterpatter.domain.assets.controller.childitem;

import com.pitpat.pitterpatter.domain.assets.model.dto.childitem.FindChildItemDto;
import com.pitpat.pitterpatter.domain.assets.service.childitem.ChildItemService;
import com.pitpat.pitterpatter.entity.ChildItem;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/assets/item-property")
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ChildItemController {

    public final ChildItemService childItemService;

    // 소유 아이템 리스트 조회
    @GetMapping("/{child_id}")
    public List<FindChildItemDto> haveItems(@PathVariable("child_id") Long childId) {
        return childItemService.haveItems(childId);
    }

    // 착용 아이템 리스트 조회
    @GetMapping("/{child_id}/on")
    public List<FindChildItemDto> isOnItems(@PathVariable("child_id") Long childId) {
        return childItemService.isOnItems(childId);
    }

    // 아이템 버리기
    @DeleteMapping("/{child_id}/{item_id}")
    public ChildItem throwOutItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemService.throwOutItem(childId, itemId);
    }

    // 아이템 구매
    @PostMapping("/{child_id}/{item_id}")
    public boolean buyItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemService.buyItem(childId, itemId);
    }

    // 아이템 탈착
    @PatchMapping("{child_id}/on/{item_id}")
    public boolean toggleItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        return childItemService.toggleItem(childId, itemId);
    }
}
