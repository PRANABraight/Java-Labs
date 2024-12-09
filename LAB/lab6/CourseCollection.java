import java.util.ArrayList;
import java.util.List;


public class CourseCollection<T extends Course<?>> {
    private List<T> courses;

    public CourseCollection() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(T course) {

        courses.add(course);
    }

    public void displayCourses() {
        for (T course : courses) {
            System.out.println(course);
        }
    }

    // Method to filter courses by category
    public void displayCoursesByCategory(CourseCategory category) {
        System.out.println("Courses in category: " + category);
        for (T course : courses) {
            if (course.getCategory() == category) {
                System.out.println(course);
            }
        }
    }
}