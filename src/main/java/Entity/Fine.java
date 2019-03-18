package Entity;

import java.util.Date;

class Fine extends Surcharge {
    Fine(Date date, int sum, String comment) {
        super(date, sum, comment);
    }

    @Override
    public int getSum() {
        return -super.getSum();
    }
}
