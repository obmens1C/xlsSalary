package entity;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "percent")
    private int percent;
    /*@OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Order> orders;*/

    public Customer(String id, String name, int percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    }

    public Customer(String id, String name, int percent, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.percent = percent;
    //    this.orders = orders;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", percent=" + percent +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Customer cst = (Customer) obj;
        return Objects.equals(name, cst.name) && percent == cst.percent;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
/*
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }*/
}
