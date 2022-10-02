package com.bobocode.creditadvisoryapp.repository;

import com.bobocode.creditadvisoryapp.enums.AppStatus;
import com.bobocode.creditadvisoryapp.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

  Optional<Application> findFirstByStatusOrderByCreatedDesc(AppStatus status);
}
