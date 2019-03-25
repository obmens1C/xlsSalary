package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToMany
    @JoinColumn(name = "order")
    private Order order;
    @Column(name = "sum")
    private int sum;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    Payment(LocalDate date, int sum, Customer customer) {
        //setId();
        this.date = date;
        this.sum = sum;
        this.customer = customer;
        this.order = null;
    }

    Payment(LocalDate date, Order order, int sum, Customer customer) {
        //setId();
        this.date = date;
        this.order = order;
        this.sum = sum;
        this.customer = customer;
    }

    Payment(LocalDate date, Order order, int sum) {
        //setId();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Payment payment = (Payment) obj;
        return Objects.equals(date, payment.date) && sum == payment.sum && payment.equals(obj) && payment.equals(obj);
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
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
