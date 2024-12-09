public class Course<T> {
    private String courseName;
    private CourseCategory category;
    private T details; // Generic type to hold additional details

    public Course(String courseName, CourseCategory category, T details) {
        this.courseName = courseName;
        this.category = category;
        this.details = details;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseCategory getCategory() {
        return category;
    }

    public T getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + ", Category: " + category + ", Details: " + details.toString();
    }
}