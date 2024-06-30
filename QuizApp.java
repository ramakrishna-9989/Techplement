public class QuizApp {
    private static QuizManager quizManager = new QuizManager();
    private static QuizTaker quizTaker = new QuizTaker();
    private static InputHelper inputHelper = new InputHelper();

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = inputHelper.getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    createQuiz();
                    break;
                case 2:
                    listQuizzes();
                    break;
                case 3:
                    takeQuiz();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Exiting quiz application. Goodbye!");
    }

    private static void displayMainMenu() {
        System.out.println("1. Create a new quiz");
        System.out.println("2. List all quizzes");
        System.out.println("3. Take a quiz");
        System.out.println("4. Exit");
    }

    private static void createQuiz() {
        String title = inputHelper.getStringInput("Enter quiz title: ");
        String description = inputHelper.getStringInput("Enter quiz description: ");
        String quizId = quizManager.createQuiz(title, description);

        boolean addMoreQuestions = true;
        while (addMoreQuestions) {
            String question = inputHelper.getStringInput("Enter question: ");
            String[] options = new String[4]; // Assuming 4 options for simplicity
            for (int i = 0; i < options.length; i++) {
                options[i] = inputHelper.getStringInput("Option " + (i + 1) + ": ");
            }
            int correctAnswerIndex = inputHelper.getIntInput("Index of correct answer (1-4): ") - 1;
            quizManager.addQuestion(quizId, question, options, correctAnswerIndex);

            addMoreQuestions = inputHelper.getStringInput("Add another question? (yes/no): ")
                    .equalsIgnoreCase("yes");
        }
    }

    private static void listQuizzes() {
        quizManager.listQuizzes();
    }

    private static void takeQuiz() {
        String quizId = inputHelper.getStringInput("Enter quiz ID to take: ");
        quizTaker.takeQuiz(quizId);
    }
}