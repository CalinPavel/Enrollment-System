package com.enrollment.app.controller;

import com.enrollment.app.helper.EnrollmentRequest;
import com.enrollment.app.model.Student;
import com.enrollment.app.service.EnrollmentService;
import com.enrollment.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping(value = "/enroll")
    public ResponseEntity<String> enroll(@RequestBody EnrollmentRequest enrollmentRequest){
          return enrollmentService.enrollStudent(enrollmentRequest);
    }


}
