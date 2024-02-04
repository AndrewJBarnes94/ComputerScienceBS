package PROGRAMMING_2.CTA6;

import java.util.ArrayList;

public class StudentSort {
    public static void main (String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(5, "Jordan Wallace", "9783 Timothy Manor, South Andrew, OK 17247"));
        students.add(new Student(8, "Nichole Miller", "37218 Dean Loaf Suite 049, Lake Kellyfort, OH 59532"));
        students.add(new Student(3, "Joanne Salas", "49568 Smith Forks, Port Meganstad, DE 60292"));
        students.add(new Student(9, "aMargaret French", "USNS Taylor, FPO AA 13254"));
        students.add(new Student(1, "Paula Taylor", "81384 Moore Park, Juliabury, KS 36060"));
        students.add(new Student(7, "Joshua Jackson", "56309 Eric Harbors Apt. 611, South Thomasport, CT 50014"));
        students.add(new Student(10, "Megan Terry", "669 Hamilton Square Apt. 334, Port Zachary, NY 72925"));
        students.add(new Student(4, "William Perkins", "PSC 0441, Box 1015, APO AA 34598"));
        students.add(new Student(2, "Jerry Knox", "284 Kimberly Knoll, Whitefort, MN 81233"));
        students.add(new Student(6, "Martin Garrison", "595 James Flat Apt. 355, Farmertown, AR 38354"));

        System.out.println("\nPre sort: ");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nPost sort by name: ");
        SelectionSort.sort(students, new SortByName());
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nPost sort by roll number: ");
        SelectionSort.sort(students, new SortByRollNo());
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
