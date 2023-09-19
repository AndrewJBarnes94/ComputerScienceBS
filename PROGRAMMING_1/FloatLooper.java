import java.util.Scanner;

public class FloatLooper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0;
        double average;
        Double maximum = null;
        Double minimum = null;

        int count = 0;
        while (count < 5) {
            try {
                System.out.print("Enter value " + (count + 1) + ": ");
                double value = scanner.nextDouble();
                total += value;

                if (maximum == null || value > maximum) {
                    maximum = value;
                }

                if (minimum == null || value < minimum) {
                    minimum = value;
                }

                count++;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        scanner.close();

        // Calculate average
        average = total / 5;

        // Calculate interest on total at 20%
        double interest = total * 0.20;

        // Display the results
        System.out.println("\nResults:");
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Maximum: " + maximum);
        System.out.println("Minimum: " + minimum);
        System.out.println("Interest on total at 20%: " + interest);
    }
}
