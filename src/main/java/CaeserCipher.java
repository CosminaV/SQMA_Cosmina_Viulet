public class CaeserCipher {

    private final int shift;


    public CaeserCipher(int shift) {
        if(shift < 1 || shift > 25) {
            throw new IllegalArgumentException("Shift must be between 1 and 25");
        }
        this.shift = shift;
    }

    public String encrypt(String message) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }
        return transform(message, shift);
    }

    public String decrypt(String encodedMessage) {
        if (encodedMessage == null || encodedMessage.isEmpty()) {
            throw new IllegalArgumentException("Encrypted message cannot be null or empty.");
        }
        return transform(encodedMessage, -shift);
    }

    private String transform(String message, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift + 26) % 26 + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
