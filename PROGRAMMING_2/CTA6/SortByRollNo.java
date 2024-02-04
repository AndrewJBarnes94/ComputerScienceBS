package PROGRAMMING_2.CTA6;

import java.util.Comparator;

public class SortByRollNo implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        return student1.rollno - student2.rollno;
    }
}
a