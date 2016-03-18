public class LongTask implements Task<Long> {

    private long number;
    private final static long PROFIT = 300l;

    public LongTask(long number) {
        this.number = number;

    }

    @Override
    public void execute() {
        number += PROFIT;
    }

    @Override
    public Long getResult() {
        return number;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public static long getProfit() {
        return PROFIT;
    }
}
