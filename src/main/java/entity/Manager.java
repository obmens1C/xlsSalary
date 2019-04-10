package entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "s_managers")
public class Manager {
    @Id
    @Column(name = "id", unique = true)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private int salary;
    @Column(name = "percent")
    private int percent;
    @OneToMany(targetEntity = Order.class, mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Order> orders;

    public Manager(String id, String name) {
        this.id = id;
        this.name = name;
        this.percent = 0;
        this.salary = 0;
    }

    Manager(String id, String name, int percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.salary = 0;
    }

    public Manager(String id, String name, int salary, int percent) {
        this.id = id;
        this.name = name;
        this.percent = percent;
        this.salary = salary;
    }

    public Manager() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percent, salary);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", percent=" + percent +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Manager mng = (Manager) obj;
        return Objects.equals(name, mng.name) && salary == mng.salary && percent == mng.percent;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
