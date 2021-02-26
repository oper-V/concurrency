package m2.e0;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String... args) {
        testArray(new Integer[0], 0);
        testArray(new Integer[]{1, 4, 10, 2}, 10);
        testArray(new Integer[]{1, 4, -10, 2}, 4);
        testArray(new Integer[]{1}, 1);
    }

    private static void testArray(final Integer[] inputArray, final int expectedResult) {
        final int actualResult = new MaxFinder(inputArray).call();
        if (actualResult != expectedResult) {
            throw new RuntimeException(
                    String.format(
                            "Actual max: %d, expected max: %d",
                            actualResult,
                            expectedResult));
        }
    }


    // BEGIN (write your solution here)
    public static class MaxFinder implements Callable<Integer> {

        private Integer[] array;
        private Integer result;

        public MaxFinder(final Integer[] inputArray) {
            this.array= inputArray;
            result = 0;
        }


        @Override
        public Integer call() {
            if (array.equals(null)) {
                result = 0;
            } else {
                //result = array[0];
                for (Integer i : array) {
                    if (i > result) {
                        result = i;
                    }
                }
            }
            return result;
        }
    }

    // END
}