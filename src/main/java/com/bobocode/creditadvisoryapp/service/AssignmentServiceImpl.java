package com.bobocode.creditadvisoryapp.service;

import com.bobocode.creditadvisoryapp.dto.AssignmentRequest;
import com.bobocode.creditadvisoryapp.enums.AppStatus;
import com.bobocode.creditadvisoryapp.repository.AdvisorRepository;
import com.bobocode.creditadvisoryapp.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AssignmentServiceImpl implements AssignmentService {

  private final AdvisorRepository advisorRepository;
  private final ApplicationRepository applicationRepository;

  @Transactional
  public void assign(AssignmentRequest request) {
    var advisor = advisorRepository.findById(request.getId())
        .orElseThrow();
    advisor.validateAssignment();
    var app = applicationRepository.findFirstByStatusOrderByCreatedDesc(AppStatus.NEW).orElseThrow();
    app.assignAdvisor(advisor);
  }
}
