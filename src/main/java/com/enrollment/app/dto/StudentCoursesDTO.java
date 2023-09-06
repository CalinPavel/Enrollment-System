package com.enrollment.app.dto;

import com.enrollment.app.model.Course;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class StudentCoursesDTO {

    private Long id;
    private String name;
    private String email;
    private List<String> courseList = new ArrayList<>();

}
