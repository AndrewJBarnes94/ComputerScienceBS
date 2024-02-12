package DATA_STRUCTURES_AND_ALGORITHMS.PortfolioProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Display {
    // Lists to hold sorted orders. One by name and one by order number
    private List<Order.OrderDetails> sortedByName;
    private List<Order.OrderDetails> sortedByOrderNumber;

    public Display() {
        // Initialize the sorted orders array lists
        this.sortedByName = new ArrayList<>();
        this.sortedByOrderNumber = new ArrayList<>();
    }

    public void updateDisplay(Queue<Order.OrderDetails> orders) {
        sortedByName = new ArrayList<>(orders);
        sortedByOrderNumber = new ArrayList<>(orders);

        // Sort lists with quick sort
        quickSort(sortedByName, 0, sortedByName.size() - 1, true);
        quickSort(sortedByOrderNumber, 0, sortedByOrderNumber.size() - 1, false);

        if(sortedByName.isEmpty()) {
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

    // Quick sort where byName = true sorted by name, and byName = false sorted by order number
    private void quickSort(List<Order.OrderDetails> list, int begin, int end, boolean byName) {
        if (begin < end) {
            int partitionIndex = partition(list, begin, end, byName);

            quickSort(list, begin, partitionIndex - 1, byName);
            quickSort(list, partitionIndex + 1, end, byName);
        }
    }

    // Partitions list around a pivot chosen as the last element in the list and elements get rearranged based on name or order number (byName = true/false).
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
