class ProgrammingCourse extends Course {
    public ProgrammingCourse() {
        super("Programming Course", 100.0); // Example title and price
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Programming Course Details: " + getCourseName() + " - " + getCourseCode());
    }
}

class DataScienceCourse extends Course {
    public DataScienceCourse() {
        super("Data Science Course", 150.0); // Example title and price
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Data Science Course Details:" + getCourseName() + " - " + getCourseCode());
    }
}

class WebDevelopmentCourse extends Course {
    public WebDevelopmentCourse() {
        super("Web Development Course", 120.0); // Example title and price
    }

    @Override
    public void getCourseDetails() {
        System.out.println("Web Development Course Details:" + getCourseName() + " - " + getCourseCode());
    }
}
