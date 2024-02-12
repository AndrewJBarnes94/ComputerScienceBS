package DATA_STRUCTURES_AND_ALGORITHMS.PortfolioProject;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
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
        orderQueue.add(new OrderDetails(lastName, orderNumber, totalCost)); // Create new order and add to queue
    }

    public OrderDetails removeItemOrdered() {
        return orderQueue.poll();
    }

    public Queue<OrderDetails> getOrderQueue() {
        return new LinkedList<>(orderQueue); // Return a copy to prevent modifications to the original LinkedList
    }

}
