package com.pitpat.pitterpatter.domain.assets.model.dto.item;

import com.pitpat.pitterpatter.entity.ChildItem;
import com.pitpat.pitterpatter.entity.enums.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class FindItemDto {
    private String itemName;
    private String photo;
    private ItemType itemType;
    private String category;

}
