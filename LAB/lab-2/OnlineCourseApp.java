import java.util.Scanner;

public class OnlineCourseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Online Course Menu ---");
            System.out.println("1. Programming Course");
            System.out.println("2. Data Science Course");
            System.out.println("3. Web Development Course");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                exit = true;
                System.out.println("Exiting the program.");
                continue;
            }

            String courseType;
            switch (choice) {
                case 1:
                    courseType = "programming";
                    break;
                case 2:
                    courseType = "datascience";
                    break;
                case 3:
                    courseType = "webdevelopment";
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    continue;
            }

            Course course = CourseFactory.createCourse(courseType);
            course.getCourseDetails();
        }

        scanner.close();
    }
}