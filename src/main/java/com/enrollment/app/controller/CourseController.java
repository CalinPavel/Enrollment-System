package com.enrollment.app.controller;

import com.enrollment.app.model.Course;
import com.enrollment.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/addCourse")
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteResource(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }

}
