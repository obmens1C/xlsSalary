package entity;

import java.util.Objects;

public class Currency {
    private String id;
    private String name;
    private int value;

    public Currency(String id, String name) {
        this.id = id;
        this.name = name;
        this.value = 0;
    }

    public Currency(String id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Currency crr = (Currency) obj;
        return Objects.equals(id, crr.id) && Objects.equals(name, crr.name);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
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
