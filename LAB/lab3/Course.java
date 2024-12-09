public class Course {
    protected final String courseName;
    protected final String courseCode;
    private final StringBuilder courseDescription;

    public Course(String courseName, String courseCode) {
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

    public void addToDescription(String detail) {
        if (detail == null || detail.trim().isEmpty()) {
            throw new IllegalArgumentException("Description detail cannot be empty or null");
        }
        courseDescription.append(detail).append("!!");
    }

    public String getCourseDescription() {
        return courseDescription.toString().trim();
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " [" + courseCode + "]");
        System.out.println("Description: " + getCourseDescription());
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }
}

record ProgrammingCourse(Course course, String language) {
    public ProgrammingCourse {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }
        if (language == null || language.trim().isEmpty()) {
            throw new IllegalArgumentException("Language cannot be empty or null");
        }
    }

    public ProgrammingCourse addCourseDetail(String detail) {
        Course updatedCourse = new Course(course.getCourseName(), course.getCourseCode());
        updatedCourse.addToDescription(course.getCourseDescription() + " " + detail);
        return new ProgrammingCourse(updatedCourse, language);
    }

    public void displayCourseInfo() {
        System.out.println("Programming Course: " + course.getCourseName() + " [" + course.getCourseCode() + "]");
        System.out.println("Language: " + language);
        System.out.println("Description: " + course.getCourseDescription());
    }
}

class TestPreparationCourse {
    private final Course course;
    private final String testType;

    public TestPreparationCourse(String courseName, String courseCode, String testType) {
        this.course = new Course(courseName, courseCode);
        if (testType == null || testType.trim().isEmpty()) {
            throw new IllegalArgumentException("Test type cannot be empty or null");
        }
        this.testType = testType;
    }

    public TestPreparationCourse addCourseDetail(String detail) {
        course.addToDescription(detail);
        return this;
    }

    public void displayCourseInfo() {
        System.out.println("Test Preparation Course: " + course.getCourseName() + " [" + course.getCourseCode() + "]");
        System.out.println("Test Type: " + testType);
        System.out.println("Description: " + course.getCourseDescription());
    }

    public String getTestType() {
        return testType;
    }
}
