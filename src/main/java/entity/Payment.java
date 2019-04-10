package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "s_payments")
public class Payment {
    @Id
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "number")
    private String number;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "order"),
            inverseJoinColumns = @JoinColumn(name = "payment"))
    private List<Order> orders;
    @Column(name = "sum")
    private double sum;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    /*@ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;*/
    @ManyToOne
    @JoinColumn(name = "currency")
    private Currency currency;

    public Payment() {

    }

    Payment(LocalDate date, int sum, Customer customer) {
        this.date = date;
        this.sum = sum;
        this.customer = customer;
        this.orders = null;
    }

    Payment(LocalDate date, List<Order> orders, int sum, Customer customer) {
        this.date = date;
        this.orders = orders;
        this.sum = sum;
        this.customer = customer;
    }

  /*  Payment(LocalDate date, List<Order> orders, int sum) {
        this.date = date;
        this.orders = orders;
        this.sum = sum;
        this.customer = orders.getCustomer();
    } */

    public Payment(String id, LocalDate date, String number, List<Order> orders, Currency currency, double sum) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.orders = orders;
        this.currency = currency;
        this.sum = sum;
        //this.manager = manager;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customer, sum);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "date=" + date +
                ", sum=" + sum +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Payment payment = (Payment) obj;
        return Objects.equals(date, payment.date) && sum == payment.sum && payment.equals(obj) && payment.equals(obj);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

        public List<Order> getOrder() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

    public double getSum() {
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
