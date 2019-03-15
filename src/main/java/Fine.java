
class Fine extends Surcharge {
    @Override
    public int getSum() {
        return -super.getSum();
    }
}
