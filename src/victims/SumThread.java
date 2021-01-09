package victims;

public class SumThread extends Thread {
    private final int[] intArray;
    private  int sumResult;

    public SumThread(int[] income) {
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
