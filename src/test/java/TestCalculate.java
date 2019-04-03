import entity.Customer;
import hibernate.ParserFrom1C;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestCalculate {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ParserFrom1C parser = new ParserFrom1C();
        /*parser.addCurrenciesToDatabase(parser.parseCurrencies());
        parser.printCurrenciesDatabase();*/

        /*parser.addManagersToDatabase(parser.parseManagers());
        parser.printManagersDatabase();*/

        /*parser.addCustomersToDatabase(parser.parseCustomers());
        parser.printCustomersDatabase();*/

        parser.addOrdersToDatabase(parser.parseOrders());
       // parser.printOrdersDatabase();

        System.exit(0);
    }
}
