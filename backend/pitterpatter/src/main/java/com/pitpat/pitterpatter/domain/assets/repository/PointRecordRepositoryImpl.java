package com.pitpat.pitterpatter.domain.assets.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class PointRecordRepositoryImpl implements PointRecordRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public PointRecordRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
