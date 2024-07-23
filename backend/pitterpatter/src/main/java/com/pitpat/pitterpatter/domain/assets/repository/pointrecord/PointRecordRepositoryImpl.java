package com.pitpat.pitterpatter.domain.assets.repository.pointrecord;

import com.pitpat.pitterpatter.entity.PointRecord;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PointRecordRepositoryImpl implements PointRecordRepositoryCustom{

    @PersistenceContext
    private EntityManager em;
    private JPAQueryFactory queryFactory;

    public PointRecordRepositoryImpl() {
        this.queryFactory = new JPAQueryFactory(this.em);
    }

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
