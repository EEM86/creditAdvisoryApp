package com.bobocode.creditadvisoryapp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@MappedSuperclass
public abstract class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;
  @Column(nullable = false)
  protected String firstName;
  @Column(nullable = false)
  protected String lastName;
  @Column(nullable = false, unique = true)
  protected String email;
  @Column(nullable = false)
  protected String cognitoUserName;
}
