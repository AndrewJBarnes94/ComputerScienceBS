package PROGRAMMING_2.PortfolioProject;

class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA){
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public int compareTo(Student student) {
        return this.name.compareTo(student.name);
    }

    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }
}
