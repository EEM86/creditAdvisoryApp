package com.bobocode.creditadvisoryapp.rest;

import com.bobocode.creditadvisoryapp.dto.AssignmentRequest;
import com.bobocode.creditadvisoryapp.service.AssignmentService;
import com.bobocode.creditadvisoryapp.service.AssignmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assign")
public class AssignmentController {

  private final AssignmentService assignmentService;

  @PostMapping
  public ResponseEntity<?> assign(@RequestBody AssignmentRequest request) {
    assignmentService.assign(request);
    return ResponseEntity.ok("Assigned");
  }
}
