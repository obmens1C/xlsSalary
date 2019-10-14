package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "mc_salary")
public class Salary {
    @Id
    @Column(unique = true)
    private String id;
    @Column
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "subdivision")
    private Subdivision subdivision;
    @Column
    private double amount;

    public Salary() {

    }

    public Salary(LocalDate date, Subdivision subdivision) {
        this.date = date;
        this.subdivision = subdivision;
        this.amount = 0;
    }

    public Salary(LocalDate date, Subdivision subdivision, double amount) {
        this.date = date;
        this.subdivision = subdivision;
        this.amount = amount;
    }

    public Salary(String id, LocalDate date, Subdivision subdivision, double amount) {
        this.id = id;
        this.date = date;
        this.subdivision = subdivision;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "date =" + date +
                ", subdivision='" + subdivision + '\'' +
                ", salary=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Salary slr = (Salary) obj;
        return Objects.equals(date, slr.date) && amount == slr.amount && Objects.equals(subdivision, slr.subdivision);
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        return result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Subdivision getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
