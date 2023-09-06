package com.enrollment.app.service;

import com.enrollment.app.model.Course;
import com.enrollment.app.model.Student;
import com.enrollment.app.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course c){
        return courseRepository.save(c);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public ResponseEntity<String> deleteCourse(Long id){

        Course current = courseRepository.findById(id).orElse(null);

        if(current != null) {
            courseRepository.delete(current);
            return ResponseEntity.ok("Course deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found: ");
    }
}
