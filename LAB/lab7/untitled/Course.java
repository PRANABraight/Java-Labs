
public class Course {
    private String name;
    private String category;
    private String level;
    private int duration;

    public Course(String name, String category, String level, int duration) {
        if(name==null|| name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        if(category==null|| category.trim().isEmpty()){
            throw new IllegalArgumentException("Category cannot be empty or null");
        }
        if(level==null|| level.trim().isEmpty()){
            throw new IllegalArgumentException("Level cannot be empty or null");
        }
        if(duration<=0){
            throw new IllegalArgumentException("Duration cannot be less than or equal to zero");
        }
        this.name = name;
        this.category = category;
        this.level = level;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getLevel() {
        return level;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', category='" + category + "', level='" + level + "', duration=" + duration + " hours}";
    }
}
