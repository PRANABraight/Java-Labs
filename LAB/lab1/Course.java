public class Course {
    private String courseName;
    private double courseDuration;
    private String tutorName;
    private String studentName;
    private int studentAge;

    // Static variable t
    private static int totalStudents = 0;

    // Constructor 
    public Course(String courseName, String tutorName) {
        this.courseName = courseName;
        this.tutorName = tutorName;
    }

    // Overloaded constructor 
    public Course(String courseName, double courseDuration, String tutorName, String studentName, int studentAge) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.tutorName = tutorName;
        this.studentName = studentName;
        this.studentAge = studentAge;
        totalStudents++;  
    }

    // Static method 
    public static int getTotalStudents() {
        return totalStudents;
    }

    // Method to display course and student details
    public void displayDetails() {
        System.out.println("Course Name: " + courseName);
        if (courseDuration > 0) {
            System.out.println("Course Duration: " + courseDuration + " hours");
        }
        System.out.println("Tutor Name: " + tutorName);
        if (studentName != null) {
            System.out.println("Student Name: " + studentName);
            System.out.println("Student Age: " + studentAge);
        }
    }

    // Overloaded static method- by course name
    public static void displayDetails(Course[] courses, String courseName) {
        for (Course course : courses) {
            if (course.courseName.equals(courseName)) {
                course.displayDetails();
                System.out.println("-----------------");
            }
        }
    }

    // Static method- by tutor name
    public static void displayDetailsByTutor(Course[] courses, String tutorName) {
        for (Course course : courses) {
            if (course.tutorName.equals(tutorName)) {
                course.displayDetails();
                System.out.println("-----------------");
            }
        }
    }

    // Static method to reset no of students
    public static void resetTotalStudents() {
        totalStudents = 0;
    }

    //  StringBuilder
    public static String getCourseDurations(Course[] courses) {
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            //method chaining
            sb.append(course.courseDuration).append(" hours, ");
        }
        //subset of sb
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {
        Course course1 = new Course("Web Stack Development", 75, "Cynthia T", "Lara", 20);
        Course course2 = new Course("Software Engineering", 45, "Neha Singhal", "Bobby", 22);
        Course course3 = new Course("Problem Solving using C", 90, "Dr. Shoney Sebastian", "Timmy", 23);

        Course[] courses = { course1, course2, course3 };

        // Display all course details
        System.out.println("Displaying all courses:");
        for (Course course : courses) {
            course.displayDetails();
            System.out.println("-----------------");
        }

        // Display specific courses
        System.out.println("Displaying courses with name 'Software Engineering':");
        Course.displayDetails(courses, "Software Engineering");

        System.out.println("Displaying courses by tutor 'Cynthia T':");
        Course.displayDetailsByTutor(courses, "Cynthia T");

        System.out.println("Total Students Enrolled: " + Course.getTotalStudents());

        // Display StringBuilder
        System.out.println("Course Names: " + course1.courseName + ", " + course2.courseName + ", " + course3.courseName);
        System.out.println("Course total duration: " + Course.getCourseDurations(courses));
    }
}
class ProgrammingCourse extends Course {
    public ProgrammingCourse() {
        super("Programming Course", 100.0); 
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Programming Course Details: " + getTitle() + " - $" + getPrice());
    }
}

class DataScienceCourse extends Course {
    public DataScienceCourse() {
        super("Data Science Course", 150.0); 
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Data Science Course Details: " + getTitle() + " - $" + getPrice());
    }
}

class WebDevelopmentCourse extends Course {
    public WebDevelopmentCourse() {
        super("Web Development Course", 120.0);
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Web Development Course Details: " + getTitle() + " - $" + getPrice());
    }
}
