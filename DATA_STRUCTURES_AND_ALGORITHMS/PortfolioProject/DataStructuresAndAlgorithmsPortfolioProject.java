package DATA_STRUCTURES_AND_ALGORITHMS.PortfolioProject;

import java.util.*;

public class DataStructuresAndAlgorithmsPortfolioProject {
    static class Order {
        static class OrderDetails {
            private String lastName;
            private int orderNumber;
            private double totalCost;

            OrderDetails(String lastName, int orderNumber, double totalCost) {
                this.lastName = lastName;
                this.orderNumber = orderNumber;
                this.totalCost = totalCost;
            }

            public String getLastName() {
                return lastName;
            }

            public int getOrderNumber() {
                return orderNumber;
            }

            public double getTotalCost() {
                return totalCost;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public void setOrderNumber(int orderNumber) {
                this.orderNumber = orderNumber;
            }

            public void setTotalCost(double totalCost) {
                this.totalCost = totalCost;
            }
        }

        Queue<OrderDetails> orderQueue = new LinkedList<>();

        public void addItemOrdered(String lastName, int orderNumber, double totalCost) {
            orderQueue.add(new OrderDetails(lastName, orderNumber, totalCost));
        }

        public OrderDetails removeItemOrdered() {
            return orderQueue.poll();
        }

        public Queue<OrderDetails> getOrderQueue() {
            return new LinkedList<>(orderQueue);
        }
    }

    static class Display {
        private List<Order.OrderDetails> sortedByName;
        private List<Order.OrderDetails> sortedByOrderNumber;

        public Display() {
            this.sortedByName = new ArrayList<>();
            this.sortedByOrderNumber = new ArrayList<>();
        }

        public void updateDisplay(Queue<Order.OrderDetails> orders) {
            sortedByName = new ArrayList<>(orders);
            sortedByOrderNumber = new ArrayList<>(orders);

            quickSort(sortedByName, 0, sortedByName.size() - 1, true);
            quickSort(sortedByOrderNumber, 0, sortedByOrderNumber.size() - 1, false);

            if (sortedByName.isEmpty()) {
                System.out.println("There are no orders yet.\n");
                return;
            }

            System.out.println("Sorted by Name:");
            for (Order.OrderDetails order : sortedByName) {
                System.out.println("\t" + order.getLastName() + "\t" + order.getOrderNumber() + "\t$" + order.getTotalCost());
            }

            System.out.println("\nSorted by Order Number:");
            for (Order.OrderDetails order : sortedByOrderNumber) {
                System.out.println("\t" + order.getLastName() + "\t" + order.getOrderNumber() + "\t$" + order.getTotalCost());
            }
        }

        private void quickSort(List<Order.OrderDetails> list, int begin, int end, boolean byName) {
            if (begin < end) {
                int partitionIndex = partition(list, begin, end, byName);

                quickSort(list, begin, partitionIndex - 1, byName);
                quickSort(list, partitionIndex + 1, end, byName);
            }
        }

        private int partition(List<Order.OrderDetails> list, int begin, int end, boolean byName) {
            Order.OrderDetails pivot = list.get(end);
            int i = (begin - 1);

            for (int j = begin; j < end; j++) {
                if (byName ? list.get(j).getLastName().compareTo(pivot.getLastName()) > 0 : list.get(j).getOrderNumber() > pivot.getOrderNumber()) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }

            Collections.swap(list, i + 1, end);
            return i + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        Order order = new Order();
        Display display = new Display();

        while (!quit) {
            System.out.println("\nStore Menu:");
            System.out.println("1. Add Order");
            System.out.println("2. Remove Order");
            System.out.println("3. Display Orders");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addOrder(scanner, order, display);
                        break;
                    case 2:
                        removeOrder(order, display);
                        break;
                    case 3:
                        displayOrders(order, display);
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number.");
                scanner.next();
            }
        }
    }

    private static void addOrder(Scanner scanner, Order order, Display display) {
        System.out.print("Enter last name: ");
        String lastName = scanner.next();
        System.out.print("Enter order number: ");
        int orderNumber = scanner.nextInt();
        System.out.print("Enter total cost: ");
        double totalCost = scanner.nextDouble();
        order.addItemOrdered(lastName, orderNumber, totalCost);
        display.updateDisplay(order.getOrderQueue());
    }

    private static void removeOrder(Order order, Display display) {
        Order.OrderDetails removedOrder = order.removeItemOrdered();
        if (removedOrder != null) {
            System.out.println("Removed order: " + removedOrder.getLastName() + " " + removedOrder.getOrderNumber() + " " + removedOrder.getTotalCost());
            display.updateDisplay(order.getOrderQueue());
        } else {
            System.out.println("No orders to remove.");
        }
    }

    private static void displayOrders(Order order, Display display) {
        display.updateDisplay(order.getOrderQueue());
    }
}
