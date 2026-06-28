package com.projects.StudentCourseRegistration.model;

public class Enrollment {

    private Integer id;
    private Integer studentId;
    private Integer courseId;

    // No-argument constructor
    public Enrollment() {
    }

    // Parameterized constructor
    public Enrollment(Integer id, Integer studentId, Integer courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}