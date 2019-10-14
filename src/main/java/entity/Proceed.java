package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mc_proceed")
public class Proceed {
    @Id
    @Column(unique = true)
    private String id;
    @Column
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "subdivision")
    private Subdivision subdivision;
    @Column
    private int sum;

    public Proceed() {
    }

    public Proceed(LocalDate date, Subdivision subdivision) {
        this.date = date;
        this.subdivision = subdivision;
    }

    public Proceed(LocalDate date, Subdivision subdivision, int sum) {
        this.date = date;
        this.subdivision = subdivision;
        this.sum = sum;
    }

    public Proceed(String id, LocalDate date, Subdivision subdivision, int sum) {
        this.id = id;
        this.date = date;
        this.subdivision = subdivision;
        this.sum = sum;
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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proceed)) return false;

        Proceed proceed = (Proceed) o;

        if (sum != proceed.sum) return false;
        if (id != null ? !id.equals(proceed.id) : proceed.id != null) return false;
        if (date != null ? !date.equals(proceed.date) : proceed.date != null) return false;
        return subdivision != null ? subdivision.equals(proceed.subdivision) : proceed.subdivision == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (subdivision != null ? subdivision.hashCode() : 0);
        result = 31 * result + sum;
        return result;
    }

    @Override
    public String toString() {
        return "Proceed{" +
                "date=" + date +
                ", subdivision=" + subdivision +
                ", sum=" + sum +
                '}';
    }
}
