package com.pitpat.pitterpatter.domain.assets.repository.pointrecord;

import com.pitpat.pitterpatter.domain.assets.model.dto.pointrecord.PointRecordSearchCondition;
import com.pitpat.pitterpatter.entity.PointRecord;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.pitpat.pitterpatter.entity.QChild.child;
import static com.pitpat.pitterpatter.entity.QPointRecord.pointRecord;

@RequiredArgsConstructor
public class PointRecordRepositoryImpl implements PointRecordRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    @Override
    public Integer findPointByChild(Long childId) {
        return queryFactory
                .select(child.point)
                .from(child)
                .where(child.id.eq(childId))
                .fetchOne();
    }

    @Override
    public List<PointRecord> findPointRecordByConditions(PointRecordSearchCondition condition, Long childId) {
        return queryFactory
                .select(pointRecord)
                .where(pointRecord.child.id.eq(childId),
                        plusAmount(condition.getAmount()),
                        minusAmount(condition.getAmount()),
                        sourceEq(condition.getSource()))
                .fetch();
    }

    private BooleanExpression plusAmount(Integer amount) {
        return amount > 0 ? pointRecord.amount.gt(amount) : null;
    }

    private BooleanExpression minusAmount(Integer amount) {
        return amount < 0 ? pointRecord.amount.gt(amount) : null;
    }

    private BooleanExpression sourceEq(String source) {
        return source == null ? null : pointRecord.source.eq(source);
    }
}
