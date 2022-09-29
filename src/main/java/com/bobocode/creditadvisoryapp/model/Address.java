package com.bobocode.creditadvisoryapp.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
  private String city;
  private String street;
  private String number;
  private Integer apt;
  private Integer zip;
}
