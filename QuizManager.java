import java.util.*;

public class QuizManager {
    private static Map<String, Quiz> quizzes = new HashMap<>();
    private int nextQuizId = 1;

    public String createQuiz(String title, String description) {
        String quizId = "Q" + nextQuizId++;
        Quiz quiz = new Quiz(quizId, title, description);
        quizzes.put(quizId, quiz);
        return quizId;
    }

    public void addQuestion(String quizId, String question, String[] options, int correctAnswerIndex) {
        Quiz quiz = quizzes.get(quizId);
        if (quiz != null) {
            quiz.addQuestion(question, options, correctAnswerIndex);
        } else {
            System.out.println("Quiz not found!");
        }
    }

    public void listQuizzes() {
        System.out.println("Available Quizzes:");
        for (Quiz quiz : quizzes.values()) {
            System.out.println("- " + quiz.getTitle() + " (" + quiz.getDescription() + ")");
        }
    }

    public static Quiz getQuiz(String quizId) {
        return quizzes.get(quizId);
    }
}
