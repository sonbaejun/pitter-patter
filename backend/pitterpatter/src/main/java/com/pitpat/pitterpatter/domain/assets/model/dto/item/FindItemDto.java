package com.pitpat.pitterpatter.domain.assets.model.dto.item;

import com.pitpat.pitterpatter.entity.ChildItem;
import com.pitpat.pitterpatter.entity.enums.ItemType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FindItemDto {
    private String itemName;
    private String photo;
    private ItemType itemType;
    private String category;
    private List<ChildItem> childItems;
    private LocalDateTime created_at;

    public FindItemDto(String itemName, String photo, ItemType itemType, String category, List<ChildItem> childItems, LocalDateTime created_at) {
        this.itemName = itemName;
        this.photo = photo;
        this.itemType = itemType;
        this.category = category;
        this.childItems = childItems;
        this.created_at = created_at;
    }
}
