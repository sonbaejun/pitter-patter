package com.pitpat.pitterpatter.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhysicalRecord {

  @Id
  @GeneratedValue
  @Column(name = "physical_record_id")
  private Long id;

  @NotNull
  private float height;

  @NotNull
  private float weight;

  @NotNull
  @CreatedDate
  private LocalDate created_at;

  @NotNull
  @LastModifiedDate
  private LocalDate updated_at;

  @NotNull
  private float bmi;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "child_id")
  private Child child;
}
