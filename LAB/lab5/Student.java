import java.util.List;

class Student extends Thread {
    private final List<Course> courses;
    private final int chosenCourseIndex;
    private final String studentName;
    private final boolean useSync;

    public Student(List<Course> courses, int chosenCourseIndex, String studentName, boolean useSync) {
        this.courses = courses;
        this.chosenCourseIndex = chosenCourseIndex;
        this.studentName = studentName;
        this.useSync = useSync;
    }

    @Override
    public void run() {
        Course chosenCourse = courses.get(chosenCourseIndex);
        if (useSync) {
            chosenCourse.enrollStudentSync(studentName);
        } else {
            chosenCourse.enrollStudentNonSync(studentName);
        }
    }
}