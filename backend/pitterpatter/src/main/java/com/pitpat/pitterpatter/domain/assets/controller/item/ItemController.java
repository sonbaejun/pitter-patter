package com.pitpat.pitterpatter.domain.assets.controller.item;

import com.pitpat.pitterpatter.domain.assets.repository.item.ItemRepository;
import com.pitpat.pitterpatter.domain.assets.service.item.ItemService;
import com.pitpat.pitterpatter.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assets")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item")
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/item/{item_id}")
    public Optional<Item> findItemByItemId(@PathVariable("item_id") Long itemId) {
        return itemService.findItemByItemId(itemId);
    }
}
