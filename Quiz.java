import java.util.*;

public class Quiz {
    private String id;
    private String title;
    private String description;
    private List<Question> questions = new ArrayList<>();

    public Quiz(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void addQuestion(String question, String[] options, int correctAnswerIndex) {
        Question newQuestion = new Question(question, options, correctAnswerIndex);
        questions.add(newQuestion);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
