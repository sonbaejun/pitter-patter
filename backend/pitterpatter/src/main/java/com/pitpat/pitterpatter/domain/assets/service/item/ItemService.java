package com.pitpat.pitterpatter.domain.assets.service.item;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.CreateItemDto;
import com.pitpat.pitterpatter.domain.assets.repository.item.ItemRepository;
import com.pitpat.pitterpatter.entity.Item;
import com.pitpat.pitterpatter.entity.enums.ItemType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final EntityManager em;
    private final ItemRepository itemRepository;

    @Transactional
    public CreateItemDto createItem(String itemName, int price, String photo, ItemType itemType, String category) {
        Item item = new Item(itemName, price, photo, itemType, category);
        itemRepository.save(item);
        return new CreateItemDto(itemName, price, photo, itemType, category);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findItemByItemId(@PathVariable("item_id") Long itemId) {
        return itemRepository.findById(itemId);
    }
}
