package com.enrollment.app;

import com.enrollment.app.model.Course;
import com.enrollment.app.model.Student;
import com.enrollment.app.repository.CourseRepository;
import com.enrollment.app.repository.EnrollmentRepository;
import com.enrollment.app.repository.StudentRepository;
import com.enrollment.app.service.CourseService;
import com.enrollment.app.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppApplicationTests {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Test
    public void testAddStudent() {
        Course course = new Course();
        course.setTitle("Java Programming");
        course.setDescription("Introduction to Java programming");
        courseService.addCourse(course);

        Course secondCourse = new Course();
        secondCourse.setTitle("Java Advanced");
        secondCourse.setDescription("Introduction to Spring");
        courseService.addCourse(secondCourse);

        Student student = new Student();
        student.setName("Gabriel");
        student.setEmail("gabriel@gmail.com");
        studentService.addStudent(student);


        assertEquals(5, courseService.getAllCourses().size());

        courseService.deleteCourse(4L);
        assertEquals(4, courseService.getAllCourses().size());
        assertEquals(4, studentService.getAllStudents().size());
    }
}
