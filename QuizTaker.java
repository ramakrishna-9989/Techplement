import java.util.List;

public class QuizTaker {
    private InputHelper inputHelper = new InputHelper();

    public void takeQuiz(String quizId) {
        Quiz quiz = QuizManager.getQuiz(quizId);
        if (quiz == null) {
            System.out.println("Quiz not found!");
            return;
        }

        List<Question> questions = quiz.getQuestions();
        int[] userResponses = new int[questions.size()];
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question currentQuestion = questions.get(i);
            displayQuestion(currentQuestion);
            int userAnswerIndex = inputHelper.getIntInput("Your answer (1-" + currentQuestion.getOptions().length + "): ") - 1;
            userResponses[i] = userAnswerIndex;
            if (userAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {
                score++;
            }
        }

        displayQuizResults(score, questions.size());
    }

    private void displayQuestion(Question question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
    }

    private void displayQuizResults(int score, int totalQuestions) {
        System.out.println("Quiz completed! You scored " + score + " out of " + totalQuestions+" Keep Practice Always Helps you");
        // Optionally, provide detailed feedback based on performance
    }
}
