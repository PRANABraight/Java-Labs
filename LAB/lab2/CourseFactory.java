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
