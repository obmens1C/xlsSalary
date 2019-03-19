package Entity;

import java.util.Objects;

class Customer {
    private static int id = 0;

    private String name;
    private int percent;

    Customer(String name) {
        setId();
        this.name = name;
        this.percent = 0;
    }

    Customer(String name, int percent) {
        setId();
        this.name = name;
        this.percent = percent;
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

    public int getId() {
        return id;
    }

   private static void setId() {
        Customer.id = Customer.id++;
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
}
