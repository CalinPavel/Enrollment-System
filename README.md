
# Tema 5  - Building a Course Enrollment System





## Authors

- [Pavel Calin](https://github.com/CalinPavel)


## API Reference

#### add student

```http
  POST /api/v1/addStudent
```

#### get all students

```http
  GET /api/v1/getAllStudents
```

#### get student's courses

```http
  GET /api/v1/getStudentCourses/{studentId}
```

#### enroll a student to a course

```http
  POST /api/v1/enroll
```

#### add a course

```http
  POST /api/v1/addCourse
```

#### delete a course

```http
  POST /deleteCourse/{id}
```






# Acknowledgements


- created a DTO to return only the id, name , email and student's courses , called StudentCoursesDTO

    `public class StudentCoursesDTO {
        private Long id;
        private String name;
        private String email;
        private List<String> courseList = new ArrayList<>();
    }`

- created a helper to receive the student ID and the course ID for the enrollment

    `public class EnrollmentRequest {
        private Long studentId;
        private Long courseId;
    }`

- added a data.sql script for database initialization
- test sources: `AppApplicationTests` , `EntityRelationshipTest`