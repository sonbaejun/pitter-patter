package com.pitpat.pitterpatter.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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

    @NotNull
    private int score;

    @NotNull
    @CreatedDate
    private LocalDateTime created_at;

    @NotNull
    private int playtime;

    @NotNull
    private int burnedCalorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_id")
    private Child child;
}
