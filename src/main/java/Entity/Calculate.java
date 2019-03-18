package Entity;

class Calculate {
    static {
        System.out.println("Расчет заработной платы");
    }
    void start() {
        Manager manager = new Manager("Kolya", 10000, 10);
        System.out.println(manager);
    }
}
