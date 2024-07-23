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

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "physical_record")
public class PhysicalRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "physical_record_id")
  private Long id;

  private float height;

  private float weight;

  @CreatedDate
  private LocalDate created_at;

  @LastModifiedDate
  private LocalDate updated_at;

  private float bmi;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "child_id")
  private Child child;

  @Builder
  public PhysicalRecord(float height, float weight, float bmi, Child child) {
    this.height = height;
    this.weight = weight;
    this.bmi = bmi;
    this.child = child;
  }
}
