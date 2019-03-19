package Entity;

class Customer {
    private String name;
    private int percent;

    public Customer(String name) {
        this.name = name;
        this.percent = 0;
    }

    public Customer(String name, int percent) {
        this.name = name;
        this.percent = percent;
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
