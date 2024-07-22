package com.pitpat.pitterpatter.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Point {

    @Id
    @GeneratedValue
    @Column(name = "point_id")
    private Long id;

    private Long amount;

    private String source;

    @JoinColumn(name = "child_id")
    private Child child;

    @CreatedDate
    private LocalDateTime created_at;

    public Point(Long amount, String source, Child child) {
        this.amount = amount;
        this.source = source;
        this.child = child;
    }
}
