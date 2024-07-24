package com.pitpat.pitterpatter.domain.assets.repository.childitem;

import com.pitpat.pitterpatter.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.pitpat.pitterpatter.entity.QChildItem.childItem;
import static com.pitpat.pitterpatter.entity.QItem.item;

@RequiredArgsConstructor
public class ChildItemRepositoryImpl implements ChildItemRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    // 아이템 구매
    @Override
    public boolean buyItem(Long childId, Long itemId) {
        // Child와 Item 엔티티 조회
        Child child = em.find(Child.class, childId);
        Item item = em.find(Item.class, itemId);

        if (child == null || item == null) {
            return false;
        }

        ChildItem childItem = new ChildItem(child, item);

        child.getChildItem().add(childItem);
        item.getChildItems().add(childItem);

        em.persist(childItem);

        return true;
    }

    // 소유 아이템 리스트 조회
    @Override
    public List<ChildItem> haveItems(Long childId) {
        return queryFactory
                .selectFrom(childItem)
                .join(childItem.item, item).fetchJoin()
                .where(childItem.child.id.eq(childId))
                .fetch();
    }

    // 착용 아이템 리스트 조회
    @Override
    public List<ChildItem> isOnItems(Long childId) {
        return queryFactory
                .selectFrom(childItem)
                .join(childItem.item, item).fetchJoin()
                .where(childItem.child.id.eq(childId), childItem.isOn.eq(true))
                .fetch();
    }

    // 아이템 버리기
    @Override
    public ChildItem throwOutItem(Long childId, Long itemId) {
        ChildItem childItemToDelete = queryFactory
                .selectFrom(childItem)
                .where(childItem.child.id.eq(childId)
                        .and(childItem.item.id.eq(itemId)))
                .fetchOne();
        if (childItemToDelete == null) {
            return null;
        }

        Child child = childItemToDelete.getChild();
        Item item = childItemToDelete.getItem();

        child.getChildItem().remove(childItemToDelete);
        item.getChildItems().remove(childItemToDelete);

        em.remove(childItemToDelete);

        return childItemToDelete;
    }

    // 아이템 탈착
    @Override
    public boolean toggleItem(Long childId, Long itemId) {
        ChildItem childItemToToggle = queryFactory
                .selectFrom(childItem)
                .where(childItem.child.id.eq(childId),
                        childItem.item.id.eq(itemId),
                        childItem.isOn.eq(true))
                .fetchOne();
        childItemToToggle.toggle();
        return childItemToToggle.isOn();
    }
}
