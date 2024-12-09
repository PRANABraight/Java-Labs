package com.elearning.course;

public class ProgrammingCourse  extends BaseCourse {
        private final String language;
    
        public ProgrammingCourse(String courseName, String courseCode, String language) {
            super(courseName, courseCode);
            if (language == null || language.trim().isEmpty()) {
                throw new IllegalArgumentException("Language cannot be empty or null");
            }
            this.language = language;
        }
    
        @Override
        public void displayCourseInfo() {
            System.out.println("Programming Course: " + courseName + " [" + courseCode + "]");
            System.out.println("Language: " + language);
            System.out.println("Description: " + getCourseDescription());
        }
    
        public String getLanguage() {
            return language;
        }
    
}
