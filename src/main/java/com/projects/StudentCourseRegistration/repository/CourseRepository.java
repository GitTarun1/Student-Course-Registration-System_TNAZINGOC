package com.projects.StudentCourseRegistration.repository;

import com.projects.StudentCourseRegistration.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public void addCourse(Course course) {

        String sql = "INSERT INTO courses (course_name, course_code, credits, available_seats) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                course.getCourseName(),
                course.getCourseCode(),
                course.getCredits(),
                course.getAvailableSeats()
        );
    }

    // READ
    public List<Course> getAllCourses() {

        String sql = "SELECT * FROM courses";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course course = new Course();

            course.setId(rs.getInt("id"));
            course.setCourseName(rs.getString("course_name"));
            course.setCourseCode(rs.getString("course_code"));
            course.setCredits(rs.getInt("credits"));
            course.setAvailableSeats(rs.getInt("available_seats")); // ✅ Added

            return course;
        });
    }

    // UPDATE
    public void updateCourse(Course course) {

        String sql = """
                UPDATE courses
                SET course_name = ?, 
                    course_code = ?, 
                    credits = ?, 
                    available_seats = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                course.getCourseName(),
                course.getCourseCode(),
                course.getCredits(),
                course.getAvailableSeats(),
                course.getId()
        );
    }

    // DELETE
    public void deleteCourse(Integer id) {

        String sql = "DELETE FROM courses WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }
}