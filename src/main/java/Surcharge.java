import java.util.Date;

abstract class Surcharge {
    private Date date;
    private int sum;
    private String comment;

    Surcharge(Date date, int sum, String comment) {
        this.date = date;
        this.sum = sum;
        this.comment = comment;
    }

    public int getSum() {
        return sum;
    }
}
