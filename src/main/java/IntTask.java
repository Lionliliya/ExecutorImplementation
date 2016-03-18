
public class IntTask implements Task<Integer> {
    private int number;
    private final static int PROFIT = 300;

    public IntTask(int number) {
        this.number = number;

    }

    @Override
    public void execute() {
        number += PROFIT;
    }

    @Override
    public Integer getResult() {
        return number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static long getProfit() {
        return PROFIT;
    }
}
