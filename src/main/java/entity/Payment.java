package entity;

import java.time.LocalDate;
import java.util.Objects;

class Payment {
    private static int id = 0;

    private LocalDate date;
    private Order order;
    private int sum;
    private Customer customer;

    Payment(LocalDate date, int sum, Customer customer) {
        setId();
        this.date = date;
        this.sum = sum;
        this.customer = customer;
        this.order = null;
    }

    Payment(LocalDate date, Order order, int sum, Customer customer) {
        setId();
        this.date = date;
        this.order = order;
        this.sum = sum;
        this.customer = customer;
    }

    Payment(LocalDate date, Order order, int sum) {
        setId();
        this.date = date;
        this.order = order;
        this.sum = sum;
        this.customer = order.getCustomer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, order, customer, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", order=" + order +
                ", sum=" + sum +
                ", customer=" + customer +
                '}';
    }

    public int getId() {
        return id;
    }

    private static void setId() {
        Payment.id = Payment.id++;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
