package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "mc_salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private LocalDate date;
    @Column
    private String subdivision_id;
    @Column
    private double amount;

    public Salary(LocalDate date, String subdivision_id) {
        this.date = date;
        this.subdivision_id = subdivision_id;
        this.amount = 0;
    }

    public Salary(LocalDate date, String subdivision_id, double amount) {
        this.date = date;
        this.subdivision_id = subdivision_id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "date=" + date +
                ", subdivision_id='" + subdivision_id + '\'' +
                ", salary=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Salary slr = (Salary) obj;
        return date == slr.date && amount == slr.amount && Objects.equals(subdivision_id, slr.subdivision_id);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (subdivision_id != null ? subdivision_id.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSubdivision_id() {
        return subdivision_id;
    }

    public void setSubdivision_id(String subdivision_id) {
        this.subdivision_id = subdivision_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
