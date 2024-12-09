import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Elearning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the student: ");
        String name = scanner.nextLine();

        System.out.println("Synchronised (true/false): ");
        boolean bolval = scanner.nextBoolean();

        System.out.println("----------------------------");
        System.out.println("Choose a Course:\n1. Java Programming\n2. Advanced Python\n3. Web Development\n4. Machine Learning");
        int choice = scanner.nextInt();

        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Java Programming"));
        courses.add(new Course("Advanced Python"));
        courses.add(new Course("Web Development"));
        courses.add(new Course("Machine Learning"));

        int chosenCourseIndex;
        if (choice >= 1 && choice <= 4) {
            chosenCourseIndex = choice - 1;
        } else {
            System.out.println(ThreadColor.getRandomColor() + "Invalid course selection. Defaulting to 'Java Programming'." + ThreadColor.getRandomColor());
            chosenCourseIndex = 0;
        }

        List<Student> students = new ArrayList<>();
        students.add(new Student(courses, 0, "Kalidas", true));
        students.add(new Student(courses, 1, "Jethro", true));
        students.add(new Student(courses, 2, "Abhinav", true));
        students.add(new Student(courses, 3, "Dave", false));
        students.add(new Student(courses, 0, "Josaiah", false));


        students.add(new Student(courses, chosenCourseIndex, name, bolval));


        students.forEach(Thread::start);


        students.forEach(student -> {
            try {
                student.join();
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.getRandomColor() + "Main thread interrupted while joining." + ThreadColor.getRandomColor());
            }
        });

        System.out.println(ThreadColor.getRandomColor() + "Enrollment process completed." + ThreadColor.getRandomColor());
        for (Course course : courses) {
            System.out.println(ThreadColor.getRandomColor() + "Students enrolled in " + course.getCourseName() + ":" + ThreadColor.getRandomColor());
            course.getEnrolledStudents().forEach(student ->
                    System.out.println(ThreadColor.getRandomColor() + student + ThreadColor.getRandomColor()));
        }
    }
}