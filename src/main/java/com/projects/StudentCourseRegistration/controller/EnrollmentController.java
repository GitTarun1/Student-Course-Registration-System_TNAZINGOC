package com.projects.StudentCourseRegistration.controller;

import com.projects.StudentCourseRegistration.model.Enrollment;
import com.projects.StudentCourseRegistration.repository.EnrollmentRepository;
import org.springframework.web.bind.annotation.*;
import com.projects.StudentCourseRegistration.model.EnrollmentDetails;
import com.projects.StudentCourseRegistration.model.EnrollmentCourse;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // CREATE
    @PostMapping
    public String addEnrollment(@RequestBody Enrollment enrollment) {

        try {
            enrollmentRepository.addEnrollment(enrollment);
            return "Enrollment added successfully";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    // READ
    @GetMapping
    public List<EnrollmentDetails> getAllEnrollments() {
        return enrollmentRepository.getAllEnrollmentDetails();
    }
    @GetMapping("/student/{studentId}")
    public List<String> getCoursesForStudent(@PathVariable Integer studentId) {

        return enrollmentRepository.getCoursesForStudent(studentId);
    }
    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Integer id) {

        enrollmentRepository.deleteEnrollment(id);

        return "Enrollment deleted successfully";
    }
    @GetMapping("/student-enrollments/{studentId}")
    public List<EnrollmentCourse> getStudentEnrollments(
            @PathVariable Integer studentId) {

        return enrollmentRepository
                .getStudentEnrollments(studentId);
    }
}