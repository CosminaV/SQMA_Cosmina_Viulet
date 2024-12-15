import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DummyUtilityTest {
    private final DummyUtility sut = new DummyUtility();

    @Test
    void testAddition() {
        assertEquals(5, sut.add(2, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(6, sut.multiply(2, 3));
    }

    @Test
    void testReverseString() {
        String result = sut.reverseString("hello");
        assertEquals("olleh", result);
    }

    @Test
    void testReverseNullString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> sut.reverseString(null));
        assertEquals("Input cannot be null", exception.getMessage());
    }
}
