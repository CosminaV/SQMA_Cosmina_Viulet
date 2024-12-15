import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CaeserCipherTest {

    private static CaeserCipher sut;

    @BeforeAll
    static void setup() {
      sut = new CaeserCipher(3);
    }

    @Test
    void testEncryptCaeserCipher() {
        String encryptedText = sut.encrypt("Hello");
        assertEquals("Khoor", encryptedText);
    }

    @Test
    void testDecryptCaeserCipher() {
        String decryptedText = sut.decrypt("Khoor");
        assertEquals("Hello", decryptedText);
    }

    @Test
    void testEncryptMessageWithSpecialCharacters() {
        String encryptedText = sut.encrypt("Hello, World!");
        assertEquals("Khoor, Zruog!", encryptedText);
    }

    @Test
    void testDecryptMessageWithSpecialCharacters() {
        String encryptedText = sut.decrypt("Khoor, Zruog!");
        assertEquals("Hello, World!", encryptedText);
    }

    @Test
    void testInvalidShift() {
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> new CaeserCipher(28));
        assertEquals("Shift must be between 1 and 25", exception.getMessage());
    }

    @Test
    void testNullMessage() {
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> sut.encrypt(null));
        assertEquals("Message cannot be null or empty.", exception.getMessage());
    }

    @Test
    void testEmptyMessage() {
        Exception exception =
                assertThrows(IllegalArgumentException.class, () -> sut.encrypt(""));
        assertEquals("Message cannot be null or empty.", exception.getMessage());
    }
}
