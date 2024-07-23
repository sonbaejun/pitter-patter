package com.pitpat.pitterpatter.domain.assets.service.item;

import com.pitpat.pitterpatter.domain.assets.model.dto.item.CreateItemDto;
import com.pitpat.pitterpatter.domain.assets.repository.item.ItemRepository;
import com.pitpat.pitterpatter.entity.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final EntityManager em;
    private final ItemRepository itemRepository;

    public Item createItem(CreateItemDto createItemDto) {
        Item item = new Item(createItemDto.getPrice(), createItemDto.getItemType(),
                createItemDto.getCategory());
        return itemRepository.save(item);
    }
}
