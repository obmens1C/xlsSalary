package Entity;

import java.time.LocalDate;

abstract class Surcharge {
    private static int id = 0;

    private LocalDate date;
    private int sum;
    private String comment;
    private Manager manager;

    Surcharge(LocalDate date, Manager manager, int sum, String comment) {
        setId();
        this.date = date;
        this.sum = sum;
        this.comment = comment;
        this.manager = manager;
    }

    public int getSum() {
        return sum;
    }

    public int getId() {
        return id;
    }

    private static void setId() {
        Surcharge.id = Surcharge.id++;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Surcharge{" +
                "date=" + date +
                ", sum=" + getSum() +
                ", comment='" + comment + '\'' +
                ", manager=" + manager +
                '}';
    }
}
