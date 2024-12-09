import java.util.Scanner;

public class Elearning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input course details
        System.out.println("Give course name: ");
        String courseName = scanner.nextLine();
        System.out.println("Select course category: \n1. PROGRAMMING,\n" +
                "2. DATA_SCIENCE,\n" +
                "3. WEB_DEVELOPMENT,\n" +
                "4. DESIGN,\n" +
                "5. BUSINESS");
        int categoryInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Give programming language/focus area: ");
        String focusArea = scanner.nextLine();
        System.out.println("Give difficulty level/duration: ");
        String difficultyOrDuration = scanner.nextLine();
        System.out.println("Select course category to display: \n1. PROGRAMMING,\n" +
                "2. DATA_SCIENCE,\n" +
                "3. WEB_DEVELOPMENT,\n" +
                "4. DESIGN,\n" +
                "5. BUSINESS");
        int catInput = scanner.nextInt();




        CourseCategory courseCategory;
        switch (categoryInput) {
            case 1 -> courseCategory = CourseCategory.PROGRAMMING;
            case 2 -> courseCategory = CourseCategory.DATA_SCIENCE;
            case 3 -> courseCategory = CourseCategory.WEB_DEVELOPMENT;
            case 4 -> courseCategory = CourseCategory.DESIGN;
            case 5 -> courseCategory = CourseCategory.BUSINESS;
            default -> {
                System.out.println("Invalid input! \nExiting...");
                return;
            }
        }

        CourseCategory courseCat;
        switch (catInput) {
            case 1 -> courseCat = CourseCategory.PROGRAMMING;
            case 2 -> courseCat = CourseCategory.DATA_SCIENCE;
            case 3 -> courseCat = CourseCategory.WEB_DEVELOPMENT;
            case 4 -> courseCat = CourseCategory.DESIGN;
            case 5 -> courseCat = CourseCategory.BUSINESS;
            default -> {
                System.out.println("Invalid input! \nExiting...");
                return;
            }
        }

        Course<?> userCourse;
        if (courseCategory == CourseCategory.BUSINESS) {
            int duration;
            try {
                duration = Integer.parseInt(difficultyOrDuration);
            } catch (NumberFormatException e) {
                System.out.println("Invalid duration provided for BUSINESS. Exiting.");
                return;
            }
            userCourse = new Course<>(courseName, courseCategory, new BusinessCourse(focusArea, duration));
        } else {
            userCourse = new Course<>(courseName, courseCategory, new ProgrammingCourse(focusArea, difficultyOrDuration));
        }

        // Predefined
        Course<ProgrammingCourse> javaCourse = new Course<>(
                "Java Programming",
                CourseCategory.PROGRAMMING,
                new ProgrammingCourse("Java", "Intermediate")
        );

        Course<BusinessCourse> leadershipCourse = new Course<>(
                "Leadership Skills",
                CourseCategory.BUSINESS,
                new BusinessCourse("Management", 40)
        );

        Course<ProgrammingCourse> pythonCourse = new Course<>(
                "Python for Data Science",
                CourseCategory.DATA_SCIENCE,
                new ProgrammingCourse("Python", "Beginner")
        );

        Course<ProgrammingCourse> figmaCourse = new Course<>(
                "Figma for Design",
                CourseCategory.DESIGN,
                new ProgrammingCourse("Figma", "Beginner")
        );

        Course<ProgrammingCourse> mernCourse = new Course<>(
                "MERN Stack",
                CourseCategory.WEB_DEVELOPMENT,
                new ProgrammingCourse("MongoDB, ExpressJs, ReactJs, NodeJs", "Advanced")
        );


        CourseCollection<Course<?>> courseCollection = new CourseCollection<>();
        courseCollection.addCourse(javaCourse);
        courseCollection.addCourse(leadershipCourse);
        courseCollection.addCourse(pythonCourse);
        courseCollection.addCourse(figmaCourse);
        courseCollection.addCourse(mernCourse);
        courseCollection.addCourse(userCourse);
        // Display all courses
        System.out.println("All Courses:");
        courseCollection.displayCourses();

        // Display courses by category
        System.out.println("\nFilter by Category:");
        courseCollection.displayCoursesByCategory(courseCat);
    }
}
