package com.projects.StudentCourseRegistration.model;


public class Course {

    private Integer id;
    private String courseName;
    private String courseCode;
    private Integer credits;
    private Integer availableSeats;

    // No-argument constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(Integer id,
                  String courseName,
                  String courseCode,
                  Integer credits,
                  Integer availableSeats) {

        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.availableSeats = availableSeats;
    }

    // Getter for id
    public Integer getId() {
        return id;
    }

    // Setter for id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Getter for courseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Setter for courseCode
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Getter for credits
    public Integer getCredits() {
        return credits;
    }

    // Setter for credits
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
