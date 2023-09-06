INSERT INTO course (title, description) VALUES ('Course 1', 'Description for Course 1');
INSERT INTO course (title, description) VALUES ('Course 2', 'Description for Course 2');
INSERT INTO course (title, description) VALUES ('Course 3', 'Description for Course 3');

INSERT INTO student (name, email) VALUES
                                      ('Student 1', 'student1@example.com'),
                                      ('Student 2', 'student2@example.com'),
                                      ('Student 3', 'student3@example.com');

INSERT INTO enrollment (course_id, student_id, date) VALUES
        ((SELECT id FROM course WHERE title = 'Course 1'), (SELECT id FROM student WHERE name = 'Student 1'), '2023-09-06'),
        ((SELECT id FROM course WHERE title = 'Course 2'), (SELECT id FROM student WHERE name = 'Student 2'), '2023-09-07'),
        ((SELECT id FROM course WHERE title = 'Course 3'), (SELECT id FROM student WHERE name = 'Student 3'), '2023-09-08');