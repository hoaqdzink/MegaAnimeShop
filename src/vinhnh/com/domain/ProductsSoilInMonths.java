package vinhnh.com.domain;

public class ProductsSoilInMonths {
    private int month;
    private long count;

    public ProductsSoilInMonths() {
    }

    public ProductsSoilInMonths(int month, long count) {
        this.month = month;
        this.count = count;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
