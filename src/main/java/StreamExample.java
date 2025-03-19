import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        System.out.println("Task 2");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList()));

        System.out.println("Task 3");
        System.out.println("filter using streams to get only even and print to console");
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);

        System.out.println("filter using streams to get their square and print to console");
        numbers.stream()
                .map(e -> e * e)
                .forEach(System.out::println);

        System.out.println("filter out odd numbers and map them to their cubes");
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * e * e)
                .forEach(System.out::println);

        System.out.println("Task 4");
        System.out.println("use reduce to get the sum of all numbers");
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum is: "+sum);

        System.out.println("use collect to gather all even numbers into a new list");
        List<Integer> evenNumbers = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers are: "+evenNumbers);

        System.out.println("Task 5");
        System.out.println("use flatmap to flatten list of lists into  a single list");
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("List of lists: "+flattenedList);

        System.out.println("use groupingBy collector to group numbers by odd and even");
        numbers.stream()
                .collect(Collectors.groupingBy(e -> e % 2 == 0))
                .forEach((k, v) -> System.out.printf("%s: %s%n", k, v));
    }

}
