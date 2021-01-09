package victims;

public class RunnableCaller {
    private int[] incomeArray;

    public RunnableCaller(int[] incomeArray) {
        this.incomeArray = incomeArray;
    }

    public static SumRunnable getResultFromSumRunnable(int[] incomeArray) throws InterruptedException {

        final SumRunnable forSum = new SumRunnable(incomeArray);
        Thread thread = new Thread(forSum);
        thread.start();
        thread.join();
        return forSum;




    }

}
