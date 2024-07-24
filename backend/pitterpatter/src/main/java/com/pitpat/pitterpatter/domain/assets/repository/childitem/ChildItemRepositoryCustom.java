package com.pitpat.pitterpatter.domain.assets.repository.childitem;

import com.pitpat.pitterpatter.entity.ChildItem;

import java.util.List;

public interface ChildItemRepositoryCustom {
    // 아이템 구매
    boolean buyItem(Long childId, Long itemId);
    // 소유 아이템 리스트 조회
    List<ChildItem> haveItems(Long childId);
    // 착용 아이템 리스트 조회
    List<ChildItem> isOnItems(Long childId);
    // 아이템 버리기
    ChildItem throwOutItem(Long childId, Long itemId);
    // 아이템 탈착
    boolean toggleItem(Long childId, Long itemId);
}
