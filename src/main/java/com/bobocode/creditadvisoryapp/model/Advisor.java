package com.bobocode.creditadvisoryapp.model;

import com.bobocode.creditadvisoryapp.enums.AppStatus;
import com.bobocode.creditadvisoryapp.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "advisors")
public class Advisor extends User {

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "advisor", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
  @ToString.Exclude
  @Setter(AccessLevel.PRIVATE)
  private List<Application> apps = new ArrayList<>();

  public void addApplication(Application app) {
    apps.add(app);
    app.setAdvisor(this);
  }

  public void removeApp(Application app) {
    apps.remove(app);
    app.setAdvisor(null);
  }

  public void validateAssignment() {
    var isAlreadyAssigned = apps.stream()
        .map(Application::getStatus)
        .filter(Objects::nonNull)
        .anyMatch(a -> a == AppStatus.ASSIGNED);
    if (isAlreadyAssigned) {
      throw new RuntimeException();
    }
  }

  public Role retrieveRole(int amount) {
    if (amount < 10_000) {
      return Role.ASSOCIATE;
    } else if (amount < 50_000) {
      return Role.PARTNER;
    } else {
      return Role.SENIOR;
    }
  }
}
