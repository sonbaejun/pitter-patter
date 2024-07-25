package com.pitpat.pitterpatter.domain.assets.controller.childitem;

import com.pitpat.pitterpatter.domain.assets.model.dto.childitem.FindChildItemDto;
import com.pitpat.pitterpatter.domain.assets.service.childitem.ChildItemService;
import com.pitpat.pitterpatter.entity.ChildItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assets/item-property")
@RequiredArgsConstructor
public class ChildItemController {

    public final ChildItemService childItemService;

    // 소유 아이템 리스트 조회
    @GetMapping("/{child_id}")
    public ResponseEntity<?> haveItems(@PathVariable("child_id") Long childId) {
        try {
            List<FindChildItemDto> items = childItemService.haveItems(childId);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아이템 조회 실패: " + e.getMessage());
        }
    }

    // 착용 아이템 리스트 조회
    @GetMapping("/{child_id}/on")
    public ResponseEntity<?> isOnItems(@PathVariable("child_id") Long childId) {
        try {
            List<FindChildItemDto> items = childItemService.isOnItems(childId);
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("착용 아이템 조회 실패: " + e.getMessage());
        }
    }

    // 아이템 버리기
    @DeleteMapping("/{child_id}/{item_id}")
    public ResponseEntity<?> throwOutItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        try {
            ChildItem deletedItem = childItemService.throwOutItem(childId, itemId);
            if (deletedItem == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이템을 찾을 수 없거나 삭제할 수 없습니다");
            }
            return ResponseEntity.ok(deletedItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아이템 삭제 실패: " + e.getMessage());
        }
    }

    // 아이템 구매
    @PostMapping("/{child_id}/{item_id}")
    public ResponseEntity<?> buyItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        try {
            Boolean success = childItemService.buyItem(childId, itemId);
            if (success == null || !success) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이템 또는 아이를 찾을 수 없습니다");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("아이템 구매 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아이템 구매 실패: " + e.getMessage());
        }
    }

    // 아이템 탈착
    @PatchMapping("{child_id}/on/{item_id}")
    public ResponseEntity<?> toggleItem(@PathVariable("child_id") Long childId, @PathVariable("item_id") Long itemId) {
        try {
            Boolean isOn = childItemService.toggleItem(childId, itemId);
            if (isOn == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("아이템을 찾을 수 없거나 토글할 수 없습니다");
            }
            return ResponseEntity.ok(isOn ? "아이템이 착용되었습니다" : "아이템이 해제되었습니다");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("아이템 토글 실패: " + e.getMessage());
        }
    }
}
