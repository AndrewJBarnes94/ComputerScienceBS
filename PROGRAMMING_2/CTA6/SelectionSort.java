package PROGRAMMING_2.CTA6;

import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static void sort(ArrayList<Student> list, Comparator<Student> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minimumIndex)) < 0) {
                    minimumIndex = j;
                }
            }
            // Swap happens here
            Student temporary = list.get(minimumIndex);
            list.set(minimumIndex, list.get(i));
            list.set(i, temporary);
        }
    }
}
