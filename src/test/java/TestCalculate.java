import entity.Calculate;
import hibernate.App;

public class TestCalculate {
    public static void main(String[] args) {
       /* Calculate calculate = new Calculate();
        calculate.start();*/

        App application = new App();
        application.printAllManagers();
    }
}
