package PROGRAMMING_2.PortfolioProject;

import java.util.LinkedList;

public class SortStudents {
    public static LinkedList<Student> mergeSort(LinkedList<Student> studentList) {
        if (studentList.size() <= 1) {
            return studentList;
        }
        
        LinkedList<Student> left = new LinkedList<>();
        LinkedList<Student> right = new LinkedList<>();
        int middle = studentList.size() / 2;
        for (int i = 0; i < middle; i++) {
            left.add(studentList.get(i));
        }
        for (int i = middle; i < studentList.size(); i++) {
            right.add(studentList.get(i));
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }
 
    private static LinkedList<Student> merge(LinkedList<Student> left, LinkedList<Student> right) {
        LinkedList<Student> merged = new LinkedList<>();

        while (!left.isEmpty() && !right.isEmpty()) {
            if (left.getFirst().compareTo(right.getFirst()) <= 0) {
                merged.add(left.removeFirst());
            } else {
                merged.add(right.removeFirst());
            }
        }

        merged.addAll(left);
        merged.addAll(right);

        return merged;
    }
 }