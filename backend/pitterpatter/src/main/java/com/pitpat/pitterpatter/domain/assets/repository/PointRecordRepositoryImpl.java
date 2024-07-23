package com.pitpat.pitterpatter.domain.assets.repository;

import com.pitpat.pitterpatter.entity.Child;
import com.pitpat.pitterpatter.entity.PointRecord;
import com.pitpat.pitterpatter.entity.QChild;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.pitpat.pitterpatter.entity.QChild.child;

@RequiredArgsConstructor
public class PointRecordRepositoryImpl implements PointRecordRepositoryCustom{

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;



    @Override
    public List<PointRecord> useOrEarnPoint(int amount, Long childId) {
        if (amount > 0) {
//            Child child = childrepository.findById(childId);
//
//            queryFactory
//                    .update(child)
//                    .set(child.point, child.point.add(amount))
//                    .where(child.id.eq(childId))
//                    .execute();
//            Point
        }
        return List.of();
    }

    @Override
    public int findPointByChild(Long childId) {
        return 0;
    }

    @Override
    public List<PointRecord> findRecordsByChild(Long childId) {
        return List.of();
    }

}
