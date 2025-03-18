import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null");
        }
        this.name = name;

        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    public static void main(String[] args) {
        System.out.println("Task 6");

        List<Person> people = Arrays.asList(
                new Person("John", 30),
                new Person("Jane", 25),
                new Person("Mike", 40),
                new Person("Anna", 22)
        );

        System.out.println("List of people:");
        people.forEach(p -> System.out.println(p.name + " is " + p.age + " years old"));

        System.out.println("People older than 25:");
        people.stream()
                .filter(p -> p.age > 25)
                .forEach(p -> System.out.println(p.name + " is " + p.age + " years old"));

        System.out.println("Oldest person in the list:");
        Person oldestPerson = people.stream()
                .max(Comparator.comparingInt(p -> p.age))
                .orElse(null);

        System.out.println(oldestPerson.name + " is the oldest person in the list at " + oldestPerson.age + " years old");
    }
}
