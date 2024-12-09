
class ProgrammingCourse {
    private String programmingLanguage;
    private String difficultyLevel;

    public ProgrammingCourse(String programmingLanguage, String difficultyLevel) {
        if (programmingLanguage == null || programmingLanguage.trim().isEmpty()) {
            throw new IllegalArgumentException("Description programming language cannot be empty or null");
        }
        if (difficultyLevel == null || difficultyLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("Description difficulty level cannot be empty or null");
        }
            this.programmingLanguage = programmingLanguage;
            this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "Programming Language: " + programmingLanguage + ", Difficulty Level: " + difficultyLevel;
    }
}

class BusinessCourse {
    private String focusArea;
    private int durationInHours;

    public BusinessCourse(String focusArea, int durationInHours) {
        if (focusArea == null || focusArea.trim().isEmpty()) {
            throw new IllegalArgumentException("Description programming language cannot be empty or null");
        }
        if (durationInHours<=0) {
            throw new IllegalArgumentException("Description difficulty level cannot be empty or null");
        }
        this.focusArea = focusArea;
        this.durationInHours = durationInHours;
    }

    @Override
    public String toString() {
        return "Focus Area: " + focusArea + ", Duration: " + durationInHours + " hours";
    }
}
