import java.util.Scanner;

public class Elearning {

    public static void main(String[] args) {
        Course elearning = new Course();
        Scanner scanner = new Scanner(System.in);

        // Predefined data with correct formats
        elearning.addCourse("MCA101", "Java Programming", "Programming", "Intermediate");
        elearning.addCourse("MCA102", "Data Structures", "Programming", "Advanced");
        elearning.addCourse("MCA103", "Digital Marketing", "Marketing", "Beginner");

        elearning.enrollStudent("Betty Smith", "MCA101");
        elearning.enrollStudent("Shetty Kumar", "MCA102");
        elearning.enrollStudent("Chloy Wilson", "MCA103");

        elearning.addUpcomingCourse("Machine Learning Basics");
        elearning.addUpcomingCourse("Cloud Computing Essentials");

        while (true) {
            System.out.println("\n--- E-Learning System ---");
            System.out.println("1. Add a Course");
            System.out.println("2. Enroll a Student in a Course");
            System.out.println("3. Add Upcoming Course");
            System.out.println("4. Display All Courses");
            System.out.println("5. Display Enrolled Students");
            System.out.println("6. Display Course Categories");
            System.out.println("7. Display Student Enrollments");
            System.out.println("8. Display Upcoming Courses");
            System.out.println("9. Display Course Levels");
            System.out.println("10. Exit");

            System.out.print("Enter your choice (1-10): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Course Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Course Level (e.g., Beginner, Intermediate, Advanced): ");
                    String level = scanner.nextLine();
                    elearning.addCourse(courseId, courseName, category, level);
                    break;

                case 2:
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Course ID: ");
                    String courseToEnroll = scanner.nextLine();
                    elearning.enrollStudent(studentName, courseToEnroll);
                    break;

                case 3:
                    System.out.print("Enter Upcoming Course Name: ");
                    String upcomingCourse = scanner.nextLine();
                    elearning.addUpcomingCourse(upcomingCourse);
                    break;

                case 4:
                    elearning.displayCourses();
                    break;

                case 5:
                    elearning.displayEnrolledStudents();
                    break;

                case 6:
                    elearning.displayCourseCategories();
                    break;

                case 7:
                    elearning.displayStudentEnrollments();
                    break;

                case 8:
                    elearning.displayUpcomingCourses();
                    break;

                case 9:
                    elearning.displayCourseLevels();
                    break;

                case 10:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
