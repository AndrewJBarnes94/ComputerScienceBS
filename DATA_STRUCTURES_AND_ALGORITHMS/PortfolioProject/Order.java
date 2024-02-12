package DATA_STRUCTURES_AND_ALGORITHMS.PortfolioProject;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
    static class OrderDetails {
        String lastName;
        int orderNumber;
        double totalCost;

        OrderDetails(String lastName, int orderNumber, double totalCost) {
            this.lastName = lastName;
            this.orderNumber = orderNumber;
            this.totalCost = totalCost;
        }
    }

    Queue<OrderDetails> orderQueue = new LinkedList<>();
    
    void addItemOrdered(String lastName, int orderNumber, double totalCost) {
        orderQueue.add(new OrderDetails(lastName, orderNumber, totalCost));
    }

    OrderDetails removeItemOrdered() {
        return orderQueue.poll();
    }

    Queue<OrderDetails> getOrderQueue() {
        return new LinkedList<>(orderQueue); // Return a copy to prevent modifications to the original LinkedList
    }
}
