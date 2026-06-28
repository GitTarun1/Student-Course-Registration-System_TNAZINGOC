package com.projects.StudentCourseRegistration.controller;

import java.util.List;
import com.projects.StudentCourseRegistration.model.Student;
import com.projects.StudentCourseRegistration.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){
        studentRepository.addStudent(student);
        return "Student added successfully";
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return studentRepository.getAllStudents();
    }
    @PutMapping("/{id}")
    public String updatestudent(@PathVariable Integer id,@RequestBody Student student){
        student.setId(id);
        studentRepository.updateStudent(student);
        return "Student updated successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        try {

            studentRepository.deleteStudent(id);

            return "Student deleted successfully";

        } catch (Exception e) {

            return "Cannot delete student. Student has active enrollments.";

        }
    }
}
