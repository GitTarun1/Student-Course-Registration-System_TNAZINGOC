package com.projects.StudentCourseRegistration.controller;

import com.projects.StudentCourseRegistration.model.Course;
import com.projects.StudentCourseRegistration.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // CREATE
    @PostMapping
    public String addCourse(@RequestBody Course course) {

        courseRepository.addCourse(course);

        return "Course added successfully";
    }

    // READ
    @GetMapping
    public List<Course> getAllCourses() {

        return courseRepository.getAllCourses();
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable Integer id,
                               @RequestBody Course course) {

        course.setId(id);

        courseRepository.updateCourse(course);

        return "Course updated successfully";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id) {

        try {

            courseRepository.deleteCourse(id);

            return "Course deleted successfully";

        } catch (Exception e) {

            return "Cannot delete course. Students are enrolled in this course.";

        }
    }
}
