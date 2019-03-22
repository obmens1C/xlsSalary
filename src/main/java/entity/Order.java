package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "manager")
    private Manager manager;
    @Column(name = "sum")
    private int sum;

    Order(LocalDate date, Customer customer, Manager manager) {
        this.date = date;
        this.customer = customer;
        this.manager = manager;
        this.sum = 0;
    }

    Order(LocalDate date, Customer customer, Manager manager, int sum) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Order ord = (Order) obj;
        return Objects.equals(date, ord.date) && sum == ord.sum && Objects.equals(manager, ord.manager) && Objects.equals(customer, ord.customer);
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
