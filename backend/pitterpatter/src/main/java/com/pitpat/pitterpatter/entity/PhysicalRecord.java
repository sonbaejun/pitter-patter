package com.pitpat.pitterpatter.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  private int height;

  @NotNull
  private int weight;

  @NotNull
  @CreatedDate
  private LocalDate created_at;

  @NotNull
  @LastModifiedDate
  private LocalDate updated_at;

  @NotNull
  private float bmi;

}
