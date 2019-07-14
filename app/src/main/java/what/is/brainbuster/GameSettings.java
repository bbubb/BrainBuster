package what.is.brainbuster;

public class GameSettings {
    private String numberOfQuestions;
    private String category;
    private String difficulty;
    private String questionType;

    public String getQuestionType() {
        return "multiple";
    }



    public String getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(String numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public GameSettings(String numberOfQuestions, String category, String difficulty, String questionType) {
        this.numberOfQuestions = numberOfQuestions;
        this.category = category;
        this.difficulty = difficulty;
        this.questionType = questionType;
    }
}
