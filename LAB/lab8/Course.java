import java.util.*;

public class Course {

    private Map<String, String> courseMap;
    private List<String> enrolledStudents;
    private Set<String> courseCategories;
    private Map<String, List<String>> studentEnrollments;
    private Queue<String> upcomingCourses;
    private SortedSet<String> courseLevels;

    public Course() {
        courseMap = new HashMap<>();
        enrolledStudents = new ArrayList<>();
        courseCategories = new HashSet<>();
        studentEnrollments = new HashMap<>();
        upcomingCourses = new LinkedList<>();
        courseLevels = new TreeSet<>();
    }

    private boolean isValidCourseId(String courseId) {
        return courseId.matches("^[A-Z]{3}\\d{3}$"); // Format: 3 uppercase letters followed by 3 digits
    }

    private boolean isValidCourseName(String courseName) {
        return courseName.matches("^[A-Za-z\\s]{3,50}$"); // Letters and spaces, 3-50 characters
    }

    private boolean isValidStudentName(String studentName) {
        return studentName.matches("^[A-Za-z\\s]{2,30}$"); // Letters and spaces, 2-30 characters
    }

    // Add
    public void addCourse(String courseId, String courseName, String category, String level) {
        if (!isValidCourseId(courseId)) {
            System.out.println("Invalid Course ID format. Use 3 uppercase letters followed by 3 digits (e.g., MCA101)");
            return;
        }
        if (!isValidCourseName(courseName)) {
            System.out.println("Invalid Course Name. Use 3-50 letters and spaces only.");
            return;
        }
        if (courseMap.containsKey(courseId)) {
            System.out.println("Course ID already exists. Use a unique ID.");
            return;
        }
        courseMap.put(courseId, courseName);
        courseCategories.add(category);
        courseLevels.add(level); // Adds the course level to the sorted set
        System.out.println("Course added successfully.");
    }

    // enroll
    public void enrollStudent(String studentName, String courseId) {
        if (!isValidStudentName(studentName)) {
            System.out.println("Invalid Student Name. Use 2-30 letters and spaces only.");
            return;
        }
        if (!isValidCourseId(courseId)) {
            System.out.println("Invalid Course ID format. Use 3 uppercase letters followed by 3 digits (e.g., MCA101)");
            return;
        }
        if (!courseMap.containsKey(courseId)) {
            System.out.println("Course ID does not exist. Please add the course first.");
            return;
        }
        if (!enrolledStudents.contains(studentName)) {
            enrolledStudents.add(studentName);
            studentEnrollments.put(studentName, new ArrayList<>());
        }
        List<String> courses = studentEnrollments.get(studentName);
        if (courses.contains(courseId)) {
            System.out.println(studentName + " is already enrolled in course ID: " + courseId);
            return;
        }
        courses.add(courseId);
        System.out.println("Student " + studentName + " enrolled successfully in course ID: " + courseId);
    }

    // Add a course
    public void addUpcomingCourse(String courseName) {
        upcomingCourses.add(courseName);
        System.out.println("Upcoming course added: " + courseName);
    }

    // Display
    public void displayUpcomingCourses() {
        System.out.println("\nUpcoming Courses:");
        if (upcomingCourses.isEmpty()) {
            System.out.println("No upcoming courses.");
        } else {
            upcomingCourses.forEach(course -> System.out.println("- " + course));
        }
    }

    public void displayStudentEnrollments() {
        System.out.println("\nStudent Enrollments:");
        if (studentEnrollments.isEmpty()) {
            System.out.println("No students enrolled in any courses.");
        } else {
            studentEnrollments.forEach(
                    (student, courses) -> System.out.println("Student: " + student + ", Enrolled Courses: " + courses));
        }
    }

    public void displayCourseLevels() {
        System.out.println("\nCourse Levels:");
        if (courseLevels.isEmpty()) {
            System.out.println("No course levels available.");
        } else {
            courseLevels.forEach(level -> System.out.println("- " + level));
        }
    }

    public void displayCourses() {
        System.out.println("\nAvailable Courses:");
        courseMap.forEach((id, name) -> System.out.println("Course ID: " + id + ", Course Name: " + name));
    }

    public void displayEnrolledStudents() {
        System.out.println("\nEnrolled Students:");
        enrolledStudents.forEach(student -> System.out.println("- " + student));
    }

    public void displayCourseCategories() {
        System.out.println("\nCourse Categories:");
        courseCategories.forEach(category -> System.out.println("- " + category));
    }
}
