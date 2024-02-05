package DATA_STRUCTURES_AND_ALGORITHMS.CTA5.Exercise4;

import java.util.Scanner;

public class FindFactorial {
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)) {
            int number;

            // Input validation loop
            while (true) {
                System.out.print("Enter a non-negative number: ");
                if (userInput.hasNextInt()) {
                    number = userInput.nextInt();
                    if (number >= 0) {
                        break; // Valid input, exit loop
                    } else {
                        System.out.println("Number must be non-negative. Please try again.\n");
                    }
                } else {
                    // Clear the invalid input
                    System.out.println("That's not a valid number. Please try again.\n");
                    userInput.next(); // Clear the buffer
                }
            }
            System.out.println();
            
            // Do tail recursion on user input to find factorial
            System.out.println("Tail Recursion");
            System.out.println("\t" + number + "! = " + Factorial.factorialTailRecursion(number, 1));

            // Do head recursion on user input to find factorial
            System.out.println("\nHead Recursion");
            int headRecursionAnswer = Factorial.factorialHeadRecursion(number);
            System.out.println("\t" + number + "! = " + headRecursionAnswer);
        }
        System.out.println();
    }
}
