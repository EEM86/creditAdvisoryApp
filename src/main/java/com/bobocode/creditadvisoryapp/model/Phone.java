package com.bobocode.creditadvisoryapp.model;

import com.bobocode.creditadvisoryapp.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@EqualsAndHashCode(of = "number")
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

  @Enumerated(EnumType.STRING)
  private PhoneType type;
  private String number;

}
