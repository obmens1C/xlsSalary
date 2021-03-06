package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mc_administrator")
public class Administrator {
    @Id
    @Column(unique = true)
    private String id;
    @Column
    private String name;

    public Administrator() {
    }

    public Administrator(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Administrator adm = (Administrator) obj;
        return Objects.equals(name, adm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "name='" + name + '\'' +
                '}';
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
}
