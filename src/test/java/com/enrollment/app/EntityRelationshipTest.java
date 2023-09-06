package com.enrollment.app;

import com.enrollment.app.helper.EnrollmentRequest;
import com.enrollment.app.model.Course;
import com.enrollment.app.model.Enrollment;
import com.enrollment.app.model.Student;
import com.enrollment.app.repository.CourseRepository;
import com.enrollment.app.repository.EnrollmentRepository;
import com.enrollment.app.repository.StudentRepository;
import com.enrollment.app.service.EnrollmentService;
import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityRelationshipTest {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EnrollmentService enrollmentService;


    @Test
    @Transactional
    public void testEnrollStudentInCourse() {

        Course course = new Course();
        course.setTitle("Java Programming");
        course.setDescription("Introduction to Java programming");
        courseRepository.save(course);

        Course secondCourse = new Course();
        secondCourse.setTitle("Java Advanced");
        secondCourse.setDescription("Introduction to Spring");
        courseRepository.save(secondCourse);

        Student student = new Student();
        student.setName("Gabriel");
        student.setEmail("gabriel@gmail.com");
        studentRepository.save(student);

        //create enroll request
        EnrollmentRequest obj = new EnrollmentRequest();
        obj.setCourseId(course.getId());
        obj.setStudentId(student.getId());
        enrollmentService.enrollStudent(obj);

        //create second enroll request
        EnrollmentRequest secondObj = new EnrollmentRequest();
        secondObj.setCourseId(secondCourse.getId());
        secondObj.setStudentId(student.getId());
        enrollmentService.enrollStudent(secondObj);


        Course retrievedCourse = courseRepository.findById(course.getId()).orElse(null);
        Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);

        assertNotNull(retrievedCourse);
        assertNotNull(retrievedStudent);

        // Verify that the course has the enrollment
        assertEquals(1, retrievedCourse.getEnrollments().size());

        // Verify that the student has the enrollment
        assertEquals(2, retrievedStudent.getEnrollments().size());
    }

}
