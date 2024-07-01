import java.util.*;

public class QuizApp {
    private List<QuizQuestion> questions;
    private int score;
    private int totalQuestions;

    public QuizApp() {
        this.questions = new ArrayList<>();
        this.score = 0;
        this.totalQuestions = 0;
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        totalQuestions = questions.size();
        int questionNumber = 1;

        for (QuizQuestion question : questions) {
            System.out.println("Question " + questionNumber + ": " + question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up!");
                    scanner.close();
                    System.exit(0);
                }
            };

            timer.schedule(task, 10000); // 10 seconds timer

            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();
            timer.cancel();

            if (userAnswer - 1 == question.getCorrectOptionIndex()) {
                score++;
            }

            questionNumber++;
        }

        scanner.close();
        displayResults();
    }

    private void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + totalQuestions);
    }
}
