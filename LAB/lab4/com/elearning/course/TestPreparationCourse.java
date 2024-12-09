package com.elearning.course;

public class TestPreparationCourse extends BaseCourse {
    private final String testType;

    public TestPreparationCourse(String courseName, String courseCode, String testType) {
        super(courseName, courseCode);
        if (testType == null || testType.trim().isEmpty()) {
            throw new IllegalArgumentException("Test type cannot be empty or null");
        }
        this.testType = testType;
    }

    @Override
    public void displayCourseInfo() {
        System.out.println("Test Preparation Course: " + getCourseName() + " [" + getCourseCode() + "]");
        System.out.println("Test Type: " + testType);
        System.out.println("Description: " + getCourseDescription());
    }

    public String getTestType() {
        return testType;
    }

    
}
