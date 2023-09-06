package com.enrollment.app.controller;

import com.enrollment.app.dto.StudentCoursesDTO;
import com.enrollment.app.model.Student;
import com.enrollment.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentCourses/{studentId}")
    public StudentCoursesDTO getStudentCourses(@PathVariable Long studentId){
        return studentService.getStudentCourses(studentId);
    }


}
