package com.elearning.course;

public abstract class BaseCourse implements Course {
    protected final String courseName;
    protected final String courseCode;
    private final StringBuilder courseDescription;

    public BaseCourse(String courseName, String courseCode) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty or null");
        }
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be empty or null");
        }
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseDescription = new StringBuilder();
    }

    @Override
    public void addCourseDetail(String detail) {
        if (detail == null || detail.trim().isEmpty()) {
            throw new IllegalArgumentException("Description detail cannot be empty or null");
        }
        courseDescription.append(detail).append(" ");
    }

    @Override
    public String getCourseDescription() {
        return courseDescription.toString().trim();
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    public void displayCourseInfo(){

    }
}