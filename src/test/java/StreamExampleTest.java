import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StreamExampleTest {
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    void filterEvenNumbersShouldReturnCorrectList() {
        List<Integer> expected = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void squareNumbersShouldReturnCorrectList() {
        List<Integer> expected = Arrays.asList(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        List<Integer> result = numbers.stream()
                .map(e -> e * e)
                .collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void filterEvenAndCubeShouldReturnCorrectList() {
        List<Integer> expected = Arrays.asList(8, 64, 216, 512, 1000);
        List<Integer> result = numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * e * e)
                .collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void reduceShouldReturnCorrectSum() {
        int expected = 55;
        int result = numbers.stream()
                .reduce(0, Integer::sum);
        assertEquals(expected, result);
    }

    @Test
    void flatMapShouldFlattenListOfLists() {
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void groupingByEvenOddShouldReturnCorrectMap() {
        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.groupingBy(e -> e % 2 == 0));

        assertTrue(result.containsKey(true));
        assertTrue(result.containsKey(false));
        assertEquals(Arrays.asList(2, 4, 6, 8, 10), result.get(true));
        assertEquals(Arrays.asList(1, 3, 5, 7, 9), result.get(false));
    }
}