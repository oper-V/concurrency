package m1.e1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadHelper {

    public static final ExecutorService EXECUTOR_SERVICE
    // BEGIN (write your solution here) Какой сервис вы создадите и присвоите ссылке выше?
           // .newFixedThreadPool(5);
            = Executors.newCachedThreadPool();

    // END

    public static long fib(final long numberToCalculate) throws Exception {
        // BEGIN (write your solution here)
        FibCalculator calc = new FibCalculator(numberToCalculate);
        final Future<?> future = EXECUTOR_SERVICE.submit(calc);
        future.get();
        return calc.getResult();



        // END
    }

    private static class FibCalculator implements Runnable {

        private final long currentNum;

        private long result = 0;

        public FibCalculator(final long numberToCalculate) {
            this.currentNum = numberToCalculate;
        }

        @Override
        public void run() {
            if (currentNum == 1 || currentNum == 2) {
                result = 1;
                return;
            }
            if (currentNum <= 0) {
                result = 0;
                return;
            }
            final FibCalculator left = new FibCalculator(currentNum - 1);
            final FibCalculator right = new FibCalculator(currentNum - 2);
            final Future leftF =  EXECUTOR_SERVICE.submit(left);
            final Future rightF =  EXECUTOR_SERVICE.submit(right);
            try {
                leftF.get();
                rightF.get();
            } catch (final InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            result = left.getResult() + right.getResult();
        }

        public long getResult() {
            return result;
        }
    }
}
