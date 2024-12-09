import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter the programming course name: ");
                String courseName = scanner.nextLine();

                System.out.print("Enter the course code: ");
                String courseCode = scanner.nextLine();

                System.out.print("Enter the programming language: ");
                String language = scanner.nextLine();

                Course baseCourse = new Course(courseName, courseCode);
                ProgrammingCourse programmingCourse = new ProgrammingCourse(baseCourse, language);
                programmingCourse = programmingCourse.addCourseDetail("Learn the basics of " + language)
                                .addCourseDetail("Advanced topics in " + language);

                System.out.println("\n--- Programming Course Information ---");
                programmingCourse.displayCourseInfo();

                System.out.println();

                System.out.print("Enter the test preparation course name:");
                String testCourseName = scanner.nextLine();

                System.out.print("Enter the course code:");
                String testCourseCode = scanner.nextLine();

                System.out.print("Enter the test type (e.g., CIA1, CIA2): ");
                String testType = scanner.nextLine();

                TestPreparationCourse testPreparationCourse = new TestPreparationCourse(testCourseName, testCourseCode,
                                testType);
                testPreparationCourse.addCourseDetail("Prepare for the " + testType + " test.")
                                .addCourseDetail("Includes practice tests and strategies.");

                System.out.println("\n--- Test Preparation Course Information ---");
                testPreparationCourse.displayCourseInfo();

                scanner.close();
        }
}
