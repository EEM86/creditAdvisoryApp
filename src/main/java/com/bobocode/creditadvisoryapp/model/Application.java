package com.bobocode.creditadvisoryapp.model;

import com.bobocode.creditadvisoryapp.enums.AppStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
  @Enumerated(EnumType.STRING)
  private AppStatus status;

  @Column(nullable = false, insertable = false, updatable = false)
  private LocalDateTime created;

  private LocalDateTime assigned;

  private LocalDateTime resolved;

  @ManyToOne(optional = false)
  @JoinColumn(name = "applicant_id")
  private Applicant applicant;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "advisor_id")
  private Advisor advisor;

  public void assignAdvisor(Advisor advisor) {
    this.setAssigned(LocalDateTime.now());
    this.setStatus(AppStatus.ASSIGNED);
    advisor.setRole(advisor.retrieveRole(this.getAmount().toBigInteger().intValue()));
    advisor.addApplication(this);
  }

}
