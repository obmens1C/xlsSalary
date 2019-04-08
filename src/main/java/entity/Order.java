package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "number")
    private String number;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;
    @Column(name = "sum")
    private double sum;
    @ManyToMany(mappedBy = "orders")
    /*@JoinTable(name = "payments",
            joinColumns = @JoinColumn(name = "paymentid"),
            inverseJoinColumns = @JoinColumn(name = "orderid"))*/
    private List<Payment> payments;
    @ManyToOne
    @JoinColumn(name = "currency")
    private Currency currency;

    Order() {

    }

    public Order(String id, String number, LocalDate date, Customer customer, Manager manager, double sum, Currency currency, List<Payment> payments) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = sum;
        this.currency = currency;
        this.payments = payments;
    }

    public Order(String id, String number, LocalDate date, Customer customer, Manager manager, double sum, Currency currency) {
        this.id = id;
        this.number = number;
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = sum;
        this.currency = currency;
    }

    Order(LocalDate date, Customer customer, Manager manager) {
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = 0;
        //   this.payment = null;
    }

    Order(LocalDate date, Customer customer, Manager manager, double sum) {
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = sum;
        //   this.payment = null;
    }

    Order(LocalDate date, Customer customer, Manager manager, double sum, Payment payment) {
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = sum;
        //   this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", customer=" + customer +
                ", manager=" + manager +
                ", sum=" + sum +
                //        ", payment=" + payment +
                //        ", currency=" + currency +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, customer, manager, sum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Order ord = (Order) obj;
        return Objects.equals(date, ord.date) && sum == ord.sum && manager.equals(obj) && customer.equals(obj);
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<Payment> getPayment() {
        return payments;
    }

    public void setPayment(List<Payment> payments) {
        this.payments = payments;
    }
}
