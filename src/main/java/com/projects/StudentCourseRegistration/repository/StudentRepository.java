package com.projects.StudentCourseRegistration.repository;

import java.util.List;
import com.projects.StudentCourseRegistration.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addStudent(Student student){
        String sql = "INSERT INTO students(first_name,last_name,email,phone) values (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone()
        );
    }

    public List<Student> getAllStudents() {

        String sql = "SELECT * FROM students";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();

            student.setId(rs.getInt("id"));
            student.setFirstName(rs.getString("first_name"));
            student.setLastName(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setPhone(rs.getString("phone"));

            return student;
        });
    }
    public void updateStudent(Student student) {

        String sql = """
            UPDATE students
            SET first_name = ?, last_name = ?, email = ?, phone = ?
            WHERE id = ?
            """;

        jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhone(),
                student.getId()
        );
    }
    public void deleteStudent(Integer id){
        String sql = "delete from students where id =?";
        jdbcTemplate.update(sql,id);
    }
}
