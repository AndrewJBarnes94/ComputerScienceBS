package PROGRAMMING_2.CTA6;

public class Student {
    int rollno;
    String name;
    String address;

    public Student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return "Student {" +
                "rollno: " + rollno +
                ", name: " + name +
                a", address: " + address +
                "}";
    }
}
