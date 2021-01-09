package victims;

public class ThreadCaller {

    private int[] incomeArray;

    public ThreadCaller(int[] incomeArray) {

        this.incomeArray = incomeArray;
    }

    public static SumThread getResultFromSumThread(int[] incomeArray) throws InterruptedException {

        final SumThread forSum = new SumThread(incomeArray);
        forSum.start();
        forSum.join();
        return forSum;

    }


}
