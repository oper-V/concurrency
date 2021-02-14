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
        // Поле, которое хранит порядковый номер числа Фибоначчи в текущем объекте.
        int currentNum;
        // Поле, которое хранит в себе результат вычисления в текущем объект
        int result;
        int lastItem; // = 1
        int beforeLastItem; //= 0



        public FibCalculator(final int numberToCalculate) {
            this.currentNum = numberToCalculate;
            this.lastItem = 1;

        }

        @Override
        public void run() {
            if(currentNum == 1) {
                result = 1;
            }
            else {
                //result = 0;
                for(int i = 1; i < currentNum; i++) {
                    result = lastItem + beforeLastItem;
                    beforeLastItem = lastItem;
                    lastItem = result;
                }
            }

        }

        public int getResult() {
            return result;
        }


        // END
    }
}
