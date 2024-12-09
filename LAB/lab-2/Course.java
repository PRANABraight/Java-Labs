abstract class Course {
    private String title;
    private double price;

    public Course(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public abstract void getCourseDetails();
}

class ProgrammingCourse extends Course {
    public ProgrammingCourse() {
        super("Programming Course", 100.0);
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Programming Course Details: " + getTitle() + " - $" + getPrice());
    }
}

class DataScienceCourse extends Course {
    public DataScienceCourse() {
        super("Data Science Course", 150.0);
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Data Science Course Details: " + getTitle() + " - $" + getPrice());
    }
}

class WebDevelopmentCourse extends Course {
    public WebDevelopmentCourse() {
        super("Web Development Course", 120.0);
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Web Development Course Details: " + getTitle() + " - $" + getPrice());
    }
}

class CourseFactory {
    public static Course createCourse(String courseType) {
        switch (courseType.toLowerCase()) {
            case "programming":
                return new ProgrammingCourse();
            case "datascience":
                return new DataScienceCourse();
            case "webdevelopment":
                return new WebDevelopmentCourse();
            default:
                throw new IllegalArgumentException("Unknown course type.");
        }
    }
}


