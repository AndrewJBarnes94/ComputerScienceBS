package DATA_STRUCTURES_AND_ALGORITHMS.PortfolioProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Two static instances for order and display classes
    private static final Order order = new Order();
    private static final Display display = new Display();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        // Main program loop with user menu
        while (!quit) {
            System.out.println();
            System.out.println("Store Menu:");
            System.out.println("1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addOrder(scanner);
                        break;
                    case 2:
                        removeOrder();
                        break;
                    case 3:
                        displayOrders();
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        // Handles when number isn't between 1 and 4
                        System.out.println("Invalid choice. Enter a number between 1 and 4.");
                }
            } 
            // Error handling for when a non numeric value is entered
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
    }

    private static void addOrder(Scanner scanner) {
        System.out.print("Enter last name: ");
        String lastName = scanner.next();

        System.out.print("Enter order number: ");
        int orderNumber = scanner.nextInt();

        System.out.print("Enter total cost: ");
        double totalCost = scanner.nextDouble();

        order.addItemOrdered(lastName, orderNumber, totalCost); // Add the order
        display.updateDisplay(order.getOrderQueue());
    }

    private static void removeOrder() {
        Order.OrderDetails removedOrder = order.removeItemOrdered(); // Remove the order
        if (removedOrder != null) {
            System.out.println("Removed order: " + removedOrder.getLastName() + " " + removedOrder.getOrderNumber() + " " + removedOrder.getTotalCost());
            display.updateDisplay(order.getOrderQueue());
        } else {
            System.out.println("No orders to remove.");
        }
    }

    private static void displayOrders() {
        display.updateDisplay(order.getOrderQueue()); // Display sorted order array lists
    }
}

