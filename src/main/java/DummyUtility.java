public class DummyUtility {
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public String reverseString(String input) {
        if (input == null) throw new IllegalArgumentException("Input cannot be null");
        return new StringBuilder(input).reverse().toString();
    }
}
