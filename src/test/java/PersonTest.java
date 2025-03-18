import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void constructorShouldCreatePersonWithValidInput() {
        Person person = new Person("John", 30);
        assertNotNull(person);
    }

    @Test
    void constructorShouldThrowExceptionForNullName() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person(null, 30)
        );
        assertEquals("Name cannot be empty or null", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionForEmptyName() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("", 30)
        );
        assertEquals("Name cannot be empty or null", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionForNegativeAge() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("John", -1)
        );
        assertEquals("Age must be between 0 and 150", exception.getMessage());
    }

    @Test
    void constructorShouldThrowExceptionForAgeAbove150() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Person("John", 151)
        );
        assertEquals("Age must be between 0 and 150", exception.getMessage());
    }
}