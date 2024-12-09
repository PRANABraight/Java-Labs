import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Elearning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input course details
        System.out.println("Enter course name: ");
        String name = scanner.nextLine();

        System.out.println("Select course category: \n1. PROGRAMMING\n2. DATA_SCIENCE\n3. WEB_DEVELOPMENT\n4. DESIGN\n5. BUSINESS");
        int categoryInput = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String courseCategory;
        switch (categoryInput) {
            case 1 -> courseCategory = "PROGRAMMING";
            case 2 -> courseCategory = "DATA_SCIENCE";
            case 3 -> courseCategory = "WEB_DEVELOPMENT";
            case 4 -> courseCategory = "DESIGN";
            case 5 -> courseCategory = "BUSINESS";
            default -> {
                System.out.println("Invalid category input! Exiting...");
                return;
            }
        }

        System.out.println("Enter course difficulty level (e.g., Beginner, Intermediate, Advanced): ");
        String level = scanner.nextLine();

        System.out.println("Enter course duration (in hours): ");
        int duration;
        try {
            duration = Integer.parseInt(scanner.nextLine());
            if (duration <= 0) {
                throw new IllegalArgumentException("Duration must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid duration input! Exiting...");
            return;
        }

        // List of Courses
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Java Programming", "PROGRAMMING", "Intermediate", 40));
        courses.add(new Course("Data Science Bootcamp", "DATA_SCIENCE", "Beginner", 60));
        courses.add(new Course("Web Development", "WEB_DEVELOPMENT", "Advanced", 50));
        courses.add(new Course("Leadership Skills", "BUSINESS", "Intermediate", 30));
        courses.add(new Course("Graphic Design", "DESIGN", "Beginner", 25));
        courses.add(new Course(name, courseCategory, level, duration)); // Add user-provided course

        // Predicate
        Predicate<Course> isProgramming = course -> course.getCategory().equals("PROGRAMMING");
        System.out.println("\nProgramming Courses:");
        courses.stream().filter(isProgramming).forEach(System.out::println);

        // Consumer
        Consumer<Course> printCourse = course -> System.out.println("Course Name: " + course.getName() + ", Duration: " + course.getDuration() + " hours");
        System.out.println("\nAll Course Details:");
        courses.forEach(printCourse);

        // Function
        Function<Course, String> courseSummary = course -> "Course: " + course.getName() + " (" + course.getDuration() + " hours)";
        System.out.println("\nCourse Summaries:");
        courses.stream().map(courseSummary).forEach(System.out::println);

        // Supplier
        Supplier<Course> defaultCourseSupplier = () -> new Course("Default Course", "GENERAL", "Beginner", 10);
        Course defaultCourse = defaultCourseSupplier.get();
        System.out.println("\nDefault Course: " + defaultCourse);

        // Combining Predicate and Consumer
        Predicate<Course> isBeginner = course -> course.getLevel().equalsIgnoreCase("Beginner");
        System.out.println("\nBeginner Courses:");
        courses.stream().filter(isBeginner).forEach(printCourse);

        // Sort
        System.out.println("\nCourses Sorted by Duration:");
        courses.stream()
                .sorted((c1, c2) -> Integer.compare(c1.getDuration(), c2.getDuration()))
                .forEach(System.out::println);
    }
}
