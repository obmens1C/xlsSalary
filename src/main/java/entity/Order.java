package entity;

import java.time.LocalDate;
import java.util.Objects;

class Order {
    private static int id = 0;

    private LocalDate date;
    private Customer customer;
    private Manager manager;
    private int sum;

    Order(LocalDate date, Customer customer, Manager manager) {
        setId();
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = 0;
    }

    Order(LocalDate date, Customer customer, Manager manager, int sum) {
        setId();
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date+
                ", customer=" + customer +
                ", manager=" + manager +
                ", sum=" + sum +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customer, manager, sum);
    }

    public int getId() {
        return id;
    }

    private static void setId() {
        Order.id = Order.id++;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
