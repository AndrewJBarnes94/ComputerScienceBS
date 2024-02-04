package PROGRAMMING_2.CTA6;

import java.util.Comparator;

public class SortByName implements Comparator<Student>{
    public int compare(Student student1, Student student2) {
        return student1.name.compareTo(student2.name);
    }
}
