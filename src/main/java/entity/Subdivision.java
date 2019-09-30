package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "mc_subdivision")
public class Subdivision {
    @Id
    @Column(unique = true)
    private String id;
    @Column
    private String name;
    @Column
    private int proceeds;

    public Subdivision() {
    }

    public Subdivision(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subdivision(String id, String name, int proceeds) {
        this.id = id;
        this.name = name;
        this.proceeds = proceeds;
    }

    @Override
    public String toString() {
        return "Subdivision{" +
                "name='" + name + '\'' +
                ", proceeds=" + proceeds +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (getClass() != obj.getClass()) return false;

        Subdivision sbv = (Subdivision) obj;

        return Objects.equals(name, sbv.name) && proceeds == sbv.proceeds;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProceeds() {
        return proceeds;
    }

    public void setProceeds(int proceeds) {
        this.proceeds = proceeds;
    }
}
