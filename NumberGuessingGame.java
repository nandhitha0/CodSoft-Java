import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        int rounds = 0;
        int score = 0;

        do {
            System.out.println("\nStarting a new round...");
            rounds++;
            int attempts = playGame(scanner);
            score += (MAX_ATTEMPTS - attempts);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\nGame Over. You played " + rounds + " rounds with a score of " + score + ".");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int attempts = 0;

        while (attempts < MAX_ATTEMPTS) {
            int guess = getUserGuess(scanner);
            attempts++;

            if (guess == number) {
                provideFeedback(guess, number);
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return attempts;
            }

            provideFeedback(guess, number);
            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
        }

        System.out.println("Sorry, you've run out of attempts. The number was " + number + ".");
        return attempts;
    }

    private static int getUserGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess (1-100): ");
            if (scanner.hasNextInt()) {
                int guess = scanner.nextInt();
                if (guess >= 1 && guess <= 100) {
                    return guess;
                } else {
                    System.out.println("Please enter a number between 1 and 100.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void provideFeedback(int guess, int number) {
        if (guess < number) {
            System.out.println("Too low!");
        } else if (guess > number) {
            System.out.println("Too high!");
        } else {
            System.out.println("Correct!");
        }
    }
