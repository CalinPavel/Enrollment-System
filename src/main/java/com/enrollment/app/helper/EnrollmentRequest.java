package com.enrollment.app.helper;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class EnrollmentRequest {
    private Long studentId;
    private Long courseId;
}
