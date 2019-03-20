package entity;

import java.time.LocalDate;

class Premium extends Surcharge {
    public Premium(LocalDate date, Manager manager, int sum, String comment) {
        super(date, manager, sum, comment);
    }

}
