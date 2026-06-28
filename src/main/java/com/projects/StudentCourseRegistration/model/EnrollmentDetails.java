package com.projects.StudentCourseRegistration.model;

public class EnrollmentDetails {

    private Integer id;
    private Integer studentId;
    private String studentName;
    private String courseName;

    public EnrollmentDetails() {
    }

    public EnrollmentDetails(Integer id, Integer studentId, String studentName, String courseName) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseName = courseName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}