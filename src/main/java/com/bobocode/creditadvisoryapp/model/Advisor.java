package com.bobocode.creditadvisoryapp.model;

import com.bobocode.creditadvisoryapp.enums.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

}
