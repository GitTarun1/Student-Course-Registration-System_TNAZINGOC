# Student Course Registration System

## Overview

A web-based Student Course Registration System developed using Spring Boot, JDBC Template, MySQL, HTML, JavaScript, and Bootstrap.

The system allows administrators to manage students, courses, and enrollments while allowing students to log in and register/drop courses.

---

## Technologies Used

- Java
- Spring Boot
- JDBC Template
- MySQL
- HTML
- JavaScript
- Bootstrap

---

## Features

### Admin Features

- Add Student
- View Students
- Update Student
- Delete Student

- Add Course
- View Courses
- Update Course
- Delete Course

- Manage Enrollments

### Student Features

- Login
- View Available Courses
- Register Courses
- View Registered Courses
- Drop Courses
- Logout

### Business Rules

- Prevent Duplicate Enrollments
- Prevent Registration When Seats Are Full
- Automatically Update Available Seats
- Foreign Key Validation

---

## Project Structure

controller/
model/
repository/
static/

---

## Future Improvements

- Spring Security
- Password Encryption
- Search Functionality
- Admin Dashboard
- Email Notifications

---

## Database Setup

1. Create a MySQL database named:

```sql
student_course_db
```

2. Run the SQL script located in:

```text
database/student_course_registration.sql
```

This will create all required tables and insert sample user records.

---

## How to Run

1. Clone the repository.

2. Open the project in IntelliJ IDEA.

3. Create the MySQL database and execute:

```text
database/student_course_registration.sql
```

4. Update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_course_db
spring.datasource.username=root
spring.datasource.password=your_password
```

5. Run:

```text
StudentCourseRegistrationApplication.java
```

6. Open the application:

```text
http://localhost:8080/login.html
```

---

## Sample Login Credentials

### Admin

Username: admin

Password: admin123

### Student

Username: tarun

Password: 1234

Username: akhil

Password: 1234

Username: shannu

Password: 1234


## Author

Tarun Kumar Chintalapudi