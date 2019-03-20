package entity;

import java.time.LocalDate;

class Fine extends Surcharge {
    Fine(LocalDate date, Manager manager, int sum, String comment) {
        super(date, manager, sum, comment);
    }

    @Override
    public int getSum() {
        return -super.getSum();
    }

}
