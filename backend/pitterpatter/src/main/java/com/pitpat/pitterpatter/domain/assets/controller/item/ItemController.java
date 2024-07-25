package com.pitpat.pitterpatter.domain.assets.controller.item;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemDto;
import com.pitpat.pitterpatter.domain.assets.model.dto.item.FindItemListDto;
import com.pitpat.pitterpatter.domain.assets.repository.item.ItemRepository;
import com.pitpat.pitterpatter.domain.assets.service.item.ItemService;
import com.pitpat.pitterpatter.entity.Item;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.processing.Find;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item")
    public List<FindItemListDto> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/item/{item_id}")
    public FindItemDto findItemByItemId(
            @PathVariable("item_id") Long itemId,
            @RequestParam("child_id") Long childId) {
        return itemService.findItemByItemId(itemId, childId);
    }
}
