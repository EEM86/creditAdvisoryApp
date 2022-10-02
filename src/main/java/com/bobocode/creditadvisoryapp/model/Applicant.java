package com.bobocode.creditadvisoryapp.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "applicants")
public class Applicant extends User {

  @Column(nullable = false)
  private String ssn;

  @Embedded
  private Address address;

  @ElementCollection
  @CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "applicant_id"))
  private List<Phone> phones = new ArrayList<>();

  @ToString.Exclude
  @OneToMany(mappedBy = "applicant", cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  @Setter(AccessLevel.PRIVATE)
  private List<Application> apps = new ArrayList<>();

  public void addApplication(Application app) {
    apps.add(app);
    app.setApplicant(this);
  }

  public void removeApp(Application app) {
    apps.remove(app);
    app.setApplicant(null);
  }


}

