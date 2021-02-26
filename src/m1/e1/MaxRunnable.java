package m1.e1;

public class MaxRunnable implements Runnable {

    private final int[] intArray;
    private  int maxResult;

    public MaxRunnable(final int[] target) {
        this.intArray = target;
    }

    public int getResult() {

        return maxResult;
    }

    @Override
    public void run() {
        maxResult = intArray[0];
        for (int j : intArray) if (maxResult < j) maxResult = j;
    }
}
