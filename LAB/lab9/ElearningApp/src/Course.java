
public class Course {
    private final int id;
    private final String name;
    private final String description;
    private final int duration;

    public Course(int id, String name, String description, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("Course{id=%d, name='%s', description='%s', duration=%d hours}",
                id, name, description, duration);
    }
}