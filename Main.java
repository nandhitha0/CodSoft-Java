public class Main {
    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();

        // Adding quiz questions
        quizApp.addQuestion(new QuizQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2));
        quizApp.addQuestion(new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1));
        quizApp.addQuestion(new QuizQuestion("Who wrote 'To Kill a Mockingbird'?", new String[]{"Harper Lee", "Mark Twain", "J.K. Rowling", "Ernest Hemingway"}, 0));
        quizApp.addQuestion(new QuizQuestion("What is the chemical symbol for water?", new String[]{"O2", "H2O", "CO2", "NaCl"}, 1));

        // Start the quiz
        quizApp.startQuiz();
    }
}
