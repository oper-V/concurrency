package victims;

public  class SumRunnable implements Runnable{
    private final int[] intArray;
    private  int sumResult;

    public SumRunnable(int[] income) {
        this.intArray = income;
    }

    public int getResult() {
        return sumResult;
    }

    @Override
    public void run() {
        for (int j : intArray) {
            sumResult = sumResult + j;
        }
    }
}
