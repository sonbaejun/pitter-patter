package com.pitpat.pitterpatter.global.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PointRecordConfig {
    @PersistenceContext
    EntityManager em;

    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(em);
    }
}
