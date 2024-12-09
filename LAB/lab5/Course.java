import java.util.ArrayList;
import java.util.List;

class Course {
    private final String courseName;
    private final List<String> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public synchronized void enrollStudentSync(String studentName) {
        System.out.println(ThreadColor.getRandomColor() + studentName + " is enrolling in " + courseName + " (Synchronized)." + ThreadColor.getRandomColor());
        
        try {
            Thread.sleep(1000); // Simulate processing delay
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.getRandomColor() + "Thread interrupted while enrolling " + studentName + ThreadColor.getRandomColor());
        }

        enrolledStudents.add(studentName);
        System.out.println(ThreadColor.getRandomColor() + studentName + " successfully enrolled in " + courseName + " (Synchronized)." + ThreadColor.getRandomColor());
    }

    public void enrollStudentNonSync(String studentName) {
        System.out.println(ThreadColor.getRandomColor() + studentName + " is enrolling in " + courseName + " (Non-Synchronized)." + ThreadColor.getRandomColor());
        try {
            Thread.sleep(1000); // Simulate processing delay
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.getRandomColor() + "Thread interrupted while enrolling " + studentName + ThreadColor.getRandomColor());
        }
        enrolledStudents.add(studentName);
        System.out.println(ThreadColor.getRandomColor() + studentName + " successfully enrolled in " + courseName + " (Non-Synchronized)." + ThreadColor.getRandomColor());
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getEnrolledStudents() {
        return enrolledStudents;
    }
}



