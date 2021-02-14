
public class Main {

    public static void main(String... args) throws Exception {
        int number = 1;
        String message = "## It is test number ";

        System.out.println(message + number++);
        testFib(1, 1);
        System.out.println(message + number++);
        testFib(2, 1);
        System.out.println(message + number++);
        testFib(3, 2);
        System.out.println(message + number++);
        testFib(4, 3);
        System.out.println(message + number++);
        testFib(5, 5);
        System.out.println(message + number++);
        testFib(6, 8);
        System.out.println(message + number++);
        testFib(7, 13);
        System.out.println(message + number);
        testFib(10, 55);
        System.out.println("End of tests!");
    }

    private static void testFib(final int fibNumber, final int expectedResult) throws Exception {
        ThreadHelper.clearCounter();
        final int actualResult = ThreadHelper.fib(fibNumber);
        if (actualResult != expectedResult) {
            throw new RuntimeException(
                    String.format("result is wrong for the input: %d, expected: %d, got: %d",
                            fibNumber,
                            expectedResult,
                            actualResult));
        }
    }
}
