package PROGRAMMING_3.Discussion7;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {

    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Target number between 1 and 100
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        try (Scanner scanner = new Scanner(System.in)) {
            while (!hasGuessedCorrectly) {
                System.out.print("Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;
                hasGuessedCorrectly = checkGuess(guess, targetNumber);
            }
        }

        System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
    }

    private static boolean checkGuess(int guess, int targetNumber) {
        if (guess == targetNumber) {
            return true;
        } else if (guess < targetNumber) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
        return false;
    }
}
