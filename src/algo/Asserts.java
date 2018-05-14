package algo;

public class Asserts {
    // expected & actual must be sorted
    public static void assertEquals(int[] expected, int[] actual) {
        if (expected.length != actual.length) {
            throw new AssertionError("Failed! Expected & actual have different size");
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                throw new AssertionError(String.format("Failed! expected: %d, but actual: %d", expected[i], actual[i]));
            }
        }
        System.out.println("Passed!");
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new AssertionError(String.format("Failed! expected: %d, but actual: %d", expected, actual));
        }
        System.out.println("Passed!");
    }

    public static void assertEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            throw new AssertionError(String.format("Failed! expected: %s, but actual: %s", expected, actual));
        }
        System.out.println("Passed!");
    }
}
