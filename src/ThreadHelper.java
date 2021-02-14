public class ThreadHelper {

    private static int threadCounter = 0;

    public static int fib(final int numberToCalculate) throws Exception {
        final FibCalculator fibCalculator = new FibCalculator(numberToCalculate);
        fibCalculator.start();
        fibCalculator.join();
        return fibCalculator.getResult();
    }

    public static void clearCounter() {
        threadCounter = 0;
    }

    private static class FibCalculator extends Thread {
        // BEGIN (write your solution here)

        // END
    }
}
