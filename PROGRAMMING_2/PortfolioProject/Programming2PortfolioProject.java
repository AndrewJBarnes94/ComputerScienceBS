package PROGRAMMING_2.PortfolioProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Programming2PortfolioProject {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LinkedList<Student> students = new LinkedList<>();

            while (true) {
                System.out.println("\nEnter student's data or type 'exit' to finish");

                System.out.print("Name: ");
                String name = scanner.nextLine();
                if (inputIsExit(name)) {
                    break;
                }

                System.out.print("Address: ");
                String address = scanner.nextLine();
                if (inputIsExit(address)) {
                    break;
                }

                double gpa = 0.0;
                while (true) {
                    System.out.print("GPA: ");
                    String gpaInput = scanner.nextLine();

                    try {
                        gpa = Double.parseDouble(gpaInput);
                        if (gpa < 0.0 || gpa > 4.0) {
                            System.out.println("Invalid GPA. Enter a valid GPA between 0.0 and 4.0.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input. Enter a numeric value representing the student's GPA.");
                    }
                }
                students.add(new Student(name, address, gpa));
            }

            students = SortStudents.mergeSort(students);

            String filename = "Students.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Student student : students) {
                    writer.write(student.toString());
                    writer.newLine();
                }
                System.out.println("Student data written to " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean inputIsExit(String userInput) {
        return userInput.equalsIgnoreCase("exit");
    }
}


class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    @Override
    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}

class SortStudents {
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
