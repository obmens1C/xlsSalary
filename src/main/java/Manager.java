import java.util.Objects;

class Manager {
    private int id;
    private String name;
    private int salary;
    private int percent;

    Manager(String name) {
        this.name = name;
        this.percent = 0;
        this.salary = 0;
    }

    Manager(String name, int salary) {
        this.name = name;
        this.percent = 0;
        this.salary = salary;
    }

    Manager(String name, int salary, int percent) {
        this.name = name;
        this.percent = percent;
        this.salary = salary;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
