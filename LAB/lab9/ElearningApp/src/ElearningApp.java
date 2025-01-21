import com.mysql.cj.jdbc.MysqlDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ElearningApp {

    public static void main(String[] args) {
        Properties props = new Properties();

        // Load database connection properties
        try {
            props.load(Files.newInputStream(Path.of("elearning.properties"), StandardOpenOption.READ));
        } catch (IOException e) {
            throw new RuntimeException("Error reading properties file. Ensure 'elearning.properties' is in the correct directory: " + e.getMessage(), e);
        }

        // Validate properties
        String serverName = props.getProperty("serverName");
        String databaseName = props.getProperty("databaseName");
        String user = props.getProperty("user");
        String portString = props.getProperty("port");
        int port;

        if (serverName == null || databaseName == null || user == null || portString == null) {
            throw new RuntimeException("Missing required properties. Ensure 'elearning.properties' contains serverName, port, databaseName, and user.");
        }

        try {
            port = Integer.parseInt(portString);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid port number in 'elearning.properties': " + portString, e);
        }

        // Set up MySQL DataSource
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(serverName);
        dataSource.setPort(port);
        dataSource.setDatabaseName(databaseName);

        // Retrieve password from environment variable
        String mysqlPassword = System.getenv("MYSQL_PASS");
        if (mysqlPassword == null) {
            throw new RuntimeException("MYSQL_PASS environment variable is not set. Please set it to the MySQL user's password.");
        }

        // Connect to the database
        try (Connection connection = dataSource.getConnection(user, mysqlPassword)) {
            System.out.println("Connected successfully to the e-learning database.");

            // Fetch and process data
            List<Course> courses = fetchCourses(connection);

            // Display all courses
            System.out.println("Available courses:");
            courses.forEach(System.out::println);

            // Filter and display courses longer than 30 hours
            System.out.println("\nCourses longer than 30 hours:");
            courses.stream()
                    .filter(course -> course.getDuration() > 30)
                    .forEach(System.out::println);

            // Search for a course by name
            System.out.println("\nSearching for courses with name containing 'Java':");
            searchCoursesByName(courses, "Java").forEach(System.out::println);

            // Sort courses by duration and display
            System.out.println("\nCourses sorted by duration:");
            courses.stream()
                    .sorted(Comparator.comparingInt(Course::getDuration))
                    .forEach(System.out::println);

            // Calculate and display the average course duration
            double avgDuration = calculateAverageDuration(courses);
            System.out.printf("\nAverage course duration: %.2f hours\n", avgDuration);

            // Group courses by duration ranges and display
            System.out.println("\nCourses grouped by duration:");
            groupCoursesByDuration(courses).forEach((category, groupedCourses) -> {
                System.out.println(category + ":");
                groupedCourses.forEach(System.out::println);
            });

        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed. Check your credentials and database status: " + e.getMessage(), e);
        }
    }

//     Fetch courses from the database.

    private static List<Course> fetchCourses(Connection connection) throws SQLException {
        String query = "SELECT id, name, description, duration FROM courses";
        List<Course> course = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                course.add(new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("duration")
                ));
            }
        }
        return course;
    }

//     Search for courses by name using Streams.

    private static List<Course> searchCoursesByName(List<Course> courses, String name) {
        return courses.stream()
                .filter(course -> course.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

// Calculate the average duration of all courses.

    private static double calculateAverageDuration(List<Course> courses) {
        return courses.stream()
                .mapToInt(Course::getDuration)
                .average()
                .orElse(0);
    }


//      Group courses by duration ranges (Short, Medium, Long).

    private static Map<String, List<Course>> groupCoursesByDuration(List<Course> courses) {
        return courses.stream()
                .collect(Collectors.groupingBy(course -> {
                    if (course.getDuration() <= 20) return "Short";
                    if (course.getDuration() <= 40) return "Medium";
                    return "Long";
                }));
    }


}
