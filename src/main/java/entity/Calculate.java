package entity;

import java.time.LocalDate;

public class Calculate {
    static {
        System.out.println("Расчет заработной платы");
    }
    public void start() {
        Manager manager = new Manager("Den", 10000, 10);
        Customer customer = new Customer("MAZDA");
        Order order = new Order(LocalDate.of(2019, 3, 12), customer, manager, 50000);
        Payment payment = new Payment(LocalDate.of(2019, 3, 19), order, 30000);
        /*/System.out.println(order);
        System.out.println(payment); */

        Fine fine = new Fine(LocalDate.of(2019, 3, 2), manager, 1000, "Ha-ha");
        System.out.println(fine);
    }
}
