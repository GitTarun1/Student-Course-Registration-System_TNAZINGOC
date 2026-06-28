package com.projects.StudentCourseRegistration.repository;

import com.projects.StudentCourseRegistration.model.Enrollment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.projects.StudentCourseRegistration.model.EnrollmentDetails;
import com.projects.StudentCourseRegistration.model.EnrollmentCourse;

import java.util.List;

@Repository
public class EnrollmentRepository {

    private final JdbcTemplate jdbcTemplate;

    public EnrollmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CREATE
    public void addEnrollment(Enrollment enrollment) {

        // Step 1: Check available seats
        String seatsSql = "SELECT available_seats FROM courses WHERE id = ?";

        Integer availableSeats = jdbcTemplate.queryForObject(
                seatsSql,
                Integer.class,
                enrollment.getCourseId()
        );

        if (availableSeats == null || availableSeats <= 0) {
            throw new RuntimeException("Course is full. No seats available.");
        }

        // Step 2: Check if the student is already enrolled
        String duplicateSql = """
                SELECT COUNT(*)
                FROM enrollments
                WHERE student_id = ? AND course_id = ?
                """;

        Integer count = jdbcTemplate.queryForObject(
                duplicateSql,
                Integer.class,
                enrollment.getStudentId(),
                enrollment.getCourseId()
        );

        if (count != null && count > 0) {
            throw new RuntimeException("Student is already enrolled in this course.");
        }

        // Step 3: Insert enrollment
        String insertSql =
                "INSERT INTO enrollments (student_id, course_id) VALUES (?, ?)";

        jdbcTemplate.update(
                insertSql,
                enrollment.getStudentId(),
                enrollment.getCourseId()
        );

        // Step 4: Decrease available seats
        String updateSeatsSql = """
                UPDATE courses
                SET available_seats = available_seats - 1
                WHERE id = ?
                """;

        jdbcTemplate.update(
                updateSeatsSql,
                enrollment.getCourseId()
        );
    }

    // READ
    public List<Enrollment> getAllEnrollments() {

        String sql = "SELECT * FROM enrollments";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Enrollment enrollment = new Enrollment();

            enrollment.setId(rs.getInt("id"));
            enrollment.setStudentId(rs.getInt("student_id"));
            enrollment.setCourseId(rs.getInt("course_id"));

            return enrollment;
        });
    }

    // DELETE
    public void deleteEnrollment(Integer id) {

        // Get the course_id before deleting
        String getCourseSql =
                "SELECT course_id FROM enrollments WHERE id = ?";

        Integer courseId = jdbcTemplate.queryForObject(
                getCourseSql,
                Integer.class,
                id
        );

        // Delete the enrollment
        String deleteSql =
                "DELETE FROM enrollments WHERE id = ?";

        jdbcTemplate.update(deleteSql, id);

        // Increase available seats by 1
        if (courseId != null) {

            String increaseSeatsSql = """
                    UPDATE courses
                    SET available_seats = available_seats + 1
                    WHERE id = ?
                    """;

            jdbcTemplate.update(increaseSeatsSql, courseId);
        }
    }
    public List<EnrollmentDetails> getAllEnrollmentDetails() {

        String sql = """
        SELECT
            e.id,
            e.student_id,
            CONCAT(s.first_name, ' ', s.last_name) AS student_name,
            c.course_name
        FROM enrollments e
        JOIN students s
            ON e.student_id = s.id
        JOIN courses c
            ON e.course_id = c.id
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            EnrollmentDetails details = new EnrollmentDetails();

            details.setId(rs.getInt("id"));
            details.setStudentId(rs.getInt("student_id"));
            details.setStudentName(rs.getString("student_name"));
            details.setCourseName(rs.getString("course_name"));

            return details;
        });
    }
    public List<String> getCoursesForStudent(Integer studentId) {

        String sql = """
            SELECT c.course_name
            FROM enrollments e
            JOIN courses c
                ON e.course_id = c.id
            WHERE e.student_id = ?
            """;

        return jdbcTemplate.queryForList(sql, String.class, studentId);
    }
    public List<EnrollmentCourse> getStudentEnrollments(Integer studentId) {

        String sql = """
        SELECT
            e.id AS enrollment_id,
            c.course_name
        FROM enrollments e
        JOIN courses c
            ON e.course_id = c.id
        WHERE e.student_id = ?
        """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            EnrollmentCourse ec = new EnrollmentCourse();

            ec.setEnrollmentId(
                    rs.getInt("enrollment_id")
            );

            ec.setCourseName(
                    rs.getString("course_name")
            );

            return ec;

        }, studentId);
    }
}