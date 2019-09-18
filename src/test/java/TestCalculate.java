import entity.Customer;
import hibernate.ParserFrom1C;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestCalculate {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ParserFrom1C parser = new ParserFrom1C();

        parser.addAdministratorsToDatabase(parser.parseAdministrators());
        parser.printAdministratorsDatabase();

        /*parser.addSubdivisionsToDatabase(parser.parseSubdivisions());
        parser.printSubdivisionsDatabase();
*/
        //parser.addCustomersToDatabase(parser.parseCustomers());
        //parser.printCustomersDatabase();

        //parser.addOrdersToDatabase(parser.parseOrders());
    //    parser.printOrdersDatabase();

        //parser.addPaymentsToDatabase(parser.parsePayments());
        System.exit(0);
    }
}
