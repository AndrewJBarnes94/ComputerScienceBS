package PROGRAMMING_2.CTA5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursiveProduct {
    public static void main(String[] args) {
        int product = recursiveProduct(1); // Start with 1
        System.out.println("The product of 5 integers is: " + product);
    }

    public static int recursiveProduct(int count) {
        if (count > 5) {
            return 1; // When 5 integers have been processed return 1 to stop multiplication (Base Case)
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                int userInput = 0;

                while (true) {
                    try {
                        System.out.println("Enter integer " + count + " of " + "5: ");
                        userInput = scanner.nextInt();
                        return userInput * recursiveProduct(count + 1); // Multiply and go to next number
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. You must enter an integer.");
                        scanner.nextLine();
                    }
                }
            }
        }
    }
}
