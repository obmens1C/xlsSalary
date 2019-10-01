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

        parser.addSubdivisionsToDatabase(parser.parseSubdivisions());
        parser.printSubdivisionsDatabase();

        parser.addSalariesToDatabase(parser.parseSalaries());
        parser.printSalariesDatabase();

        parser.addWorkshiftsToDataBase(parser.parseWorkshifts());
        parser.printWorkshiftsDatabase();

        System.exit(0);
    }
}
