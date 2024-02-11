package PROGRAMMING_2.PortfolioProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentManagement {
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
                            System.out.println("Invalid GPA\nEnter a valid GPA between 0.0 and 4.0");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Input\nEnter a numeric value representing the student's GPA");
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
        if (userInput.equalsIgnoreCase("exit")) {
            return true;
        } else {
            return false;
        }
    }
}
