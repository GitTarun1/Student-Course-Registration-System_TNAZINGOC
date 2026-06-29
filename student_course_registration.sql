CREATE DATABASE IF NOT EXISTS student_course_db;

USE student_course_db;

CREATE TABLE students (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          phone VARCHAR(15)
);

CREATE TABLE courses (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         course_name VARCHAR(50) NOT NULL,
                         course_code VARCHAR(50) NOT NULL,
                         credits INT NOT NULL,
                         available_seats INT NOT NULL DEFAULT 30
);

CREATE TABLE enrollments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             student_id INT NOT NULL,
                             course_id INT NOT NULL,

                             FOREIGN KEY (student_id)
                                 REFERENCES students(id),

                             FOREIGN KEY (course_id)
                                 REFERENCES courses(id)
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       role VARCHAR(20) NOT NULL,
                       student_id INT
);

INSERT INTO users(username, password, role, student_id)
VALUES
    ('admin', 'admin123', 'ADMIN', NULL),
    ('tarun', '1234', 'STUDENT', 1),
    ('akhil', '1234', 'STUDENT', 2),
    ('shannu', '1234', 'STUDENT', 3),
    ('mouli', '1234', 'STUDENT', 4),
    ('subbu', '1234', 'STUDENT', 5);