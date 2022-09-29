package com.bobocode.creditadvisoryapp.model;

import com.bobocode.creditadvisoryapp.enums.AppStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "applications")
public class Application {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private BigDecimal amount;

  @Column(nullable = false)
  private AppStatus status;

  @Column(nullable = false, insertable = false, updatable = false)
  private LocalDateTime created;

  private LocalDateTime assigned;

  private LocalDateTime resolved;

  @ManyToOne(optional = false)
  @JoinColumn(name = "applicant_id")
  private Applicant applicant;

  @ManyToOne
  @JoinColumn(name = "advisor_id")
  private Advisor advisor;

}
