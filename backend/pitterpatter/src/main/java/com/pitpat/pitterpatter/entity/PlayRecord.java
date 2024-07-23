package com.pitpat.pitterpatter.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "play_record")
public class PlayRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_record_id")
    private Long id;

    private int score;

    @CreatedDate
    private LocalDateTime created_at;

    private int playtime;

    private int burnedCalorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;

    @Builder
    public PlayRecord(int score, int playtime, int burnedCalorie, Child child) {
        this.score = score;
        this.playtime = playtime;
        this.burnedCalorie = burnedCalorie;
        this.child = child;
    }
}
