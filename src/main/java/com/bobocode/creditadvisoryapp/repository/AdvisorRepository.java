package com.bobocode.creditadvisoryapp.repository;

import com.bobocode.creditadvisoryapp.model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Integer> {

}
