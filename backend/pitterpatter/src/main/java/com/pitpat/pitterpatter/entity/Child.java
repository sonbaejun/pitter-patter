package com.pitpat.pitterpatter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pitpat.pitterpatter.entity.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "profile_image")
    private String profileImage;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private LocalDate birth;

    @Column(name = "personal_record")
    private int personalRecord = 0;

    private int point = 0;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private List<ChildItem> childItems = new ArrayList<>();

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private List<PointRecord> points = new ArrayList<>();

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private List<PhysicalRecord> physicalRecords = new ArrayList<>();

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private List<PlayRecord> playRecords = new ArrayList<>();

    @Builder
    public Child(String profileImage, UserEntity user, String nickname, Gender gender, LocalDate birth, int personalRecord, int point, List<ChildItem> childItems, List<PointRecord> points, List<PhysicalRecord> physicalRecords, List<PlayRecord> playRecords) {
        this.profileImage = profileImage;
        this.user = user;
        this.nickname = nickname;
        this.gender = gender;
        this.birth = birth;
        this.personalRecord = personalRecord;
        this.point = point;
        this.childItems = childItems;
        this.points = points;
        this.physicalRecords = physicalRecords;
        this.playRecords = playRecords;
    }
}
