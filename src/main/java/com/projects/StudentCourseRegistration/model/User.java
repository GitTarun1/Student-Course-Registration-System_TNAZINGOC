package com.projects.StudentCourseRegistration.model;

public class User {

    private Integer id;
    private String username;
    private String password;
    private String role;
    private Integer studentId;
    public User() {
    }

    public User(Integer id,
                String username,
                String password,
                String role,
                Integer studentId) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.studentId = studentId;
    }
    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}