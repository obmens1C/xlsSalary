import hibernate.App;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestCalculate {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        App application = new App();
        application.parseXML();
        //application.printAllCurrencies();
        application.printAllManagers();
       /*application.printAllCustomers();
       application.printAllOrders();*/
        System.exit(0);
    }
}
