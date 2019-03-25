package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private int salary;
    @Column(name = "percent")
    private int percent;

    Manager(String name) {
        this.name = name;
        this.percent = 0;
        this.salary = 0;
    }

    Manager(String name, int percent) {
        this.name = name;
        this.percent = percent;
        this.salary = 0;
    }

    public Manager(String name, int salary, int percent) {
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

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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
