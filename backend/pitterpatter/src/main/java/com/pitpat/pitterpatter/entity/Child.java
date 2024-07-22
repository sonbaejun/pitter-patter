package com.pitpat.pitterpatter.entity;

import com.pitpat.pitterpatter.entity.ENUM.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "child")
public class Child {

    @Id @GeneratedValue
    @Column(name = "child_id")
    @NotNull
    private Long id;

    // TODO: user_id FK 필요.

    private String profile_image;

    @NotNull
    private String nickname;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @CreatedDate
    @NotNull
    private LocalDate created_at;

    @LastModifiedDate
    @NotNull
    private LocalDate updated_at;

    @NotNull
    private LocalDate birth;

    @NotNull
    private int personal_record;

    @NotNull
    private int point;

    @OneToMany(fetch = FetchType.LAZY)
    @NotNull
    private List<ChildItem> childItem = new ArrayList<>();

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    @NotNull
    private List<Point> points = new ArrayList<>();
}
