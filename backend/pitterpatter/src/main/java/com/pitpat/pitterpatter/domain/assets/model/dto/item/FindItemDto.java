package com.pitpat.pitterpatter.domain.assets.model.dto.item;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.ChildItem;
import com.pitpat.pitterpatter.entity.enums.ItemType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class FindItemDto {
    // id 아이템 이미지, 가격, 소유, 착용
    private Long id;
    private String itemName;
    private int price;
    private String photo;
    private boolean is_on;
}
