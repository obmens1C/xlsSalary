package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "mc_salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "subdivision")
    private Subdivision subdivision;
    @Column
    private double amount;

    public Salary() {

    }

    public Salary(LocalDateTime dateTime, Subdivision subdivision) {
        this.dateTime = dateTime;
        this.subdivision = subdivision;
        this.amount = 0;
    }

    public Salary(LocalDateTime dateTime, Subdivision subdivision, double amount) {
        this.dateTime = dateTime;
        this.subdivision = subdivision;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "date time=" + dateTime +
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
        return Objects.equals(dateTime, slr.dateTime) && amount == slr.amount && Objects.equals(subdivision, slr.subdivision);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
