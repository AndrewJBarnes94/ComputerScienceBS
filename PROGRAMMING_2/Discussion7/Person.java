package PROGRAMMING_2.Discussion7;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }    

    public static void main(String args[]) {
        Person andrew1 = new Person("Andrew", 1);
        Person andrew2 = new Person("Andrew", 2);

        List<Person> people = new ArrayList<>();
        people.add(andrew1);
        people.add(andrew2);

        System.out.println(people);

        for (Person person : people) {
            System.out.println(person.getName());
        }        
    }
}

