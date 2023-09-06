package com.enrollment.app.service;

import com.enrollment.app.dto.StudentCoursesDTO;
import com.enrollment.app.model.Enrollment;
import com.enrollment.app.model.Student;
import com.enrollment.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student s){
        return studentRepository.save(s);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public StudentCoursesDTO getStudentCourses(Long StudentId){
        StudentCoursesDTO currentDTO = new StudentCoursesDTO();

        Student currentStudent = studentRepository.findById(StudentId)
                        .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        currentDTO.setId(StudentId);
        currentDTO.setEmail(currentStudent.getEmail());
        currentDTO.setName(currentStudent.getName());

        List<Enrollment> myList = currentStudent.getEnrollments();
        if(!myList.isEmpty()) {
            for (Enrollment itr : myList)
                    currentDTO.getCourseList().add(itr.getCourse().getTitle());
        }

        return  currentDTO;
    }

}
