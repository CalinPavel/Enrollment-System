package com.enrollment.app.service;

import com.enrollment.app.helper.EnrollmentRequest;
import com.enrollment.app.model.Course;
import com.enrollment.app.model.Enrollment;
import com.enrollment.app.model.Student;
import com.enrollment.app.repository.CourseRepository;
import com.enrollment.app.repository.EnrollmentRepository;
import com.enrollment.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void addEnrollment(Enrollment e){
        enrollmentRepository.save(e);
    }

    public ResponseEntity<String> enrollStudent(EnrollmentRequest enrollmentRequest){
        try {
            Student student = studentRepository.findById(enrollmentRequest.getStudentId())
                    .orElseThrow(() -> new IllegalArgumentException("Student not found"));

            Course course = courseRepository.findById(enrollmentRequest.getCourseId())
                    .orElseThrow(() -> new IllegalArgumentException("Course not found"));

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollment.setDate(new Date());
            student.getEnrollments().add(enrollment);
            course.getEnrollments().add(enrollment);

            enrollmentRepository.save(enrollment);

            return ResponseEntity.ok("Student enrolled in course successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Enrollment failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Enrollment failed: " + e.getMessage());
        }
    }

}
