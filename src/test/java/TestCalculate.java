import hibernate.ParserFrom1C;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestCalculate {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        ParserFrom1C parser = new ParserFrom1C();

        parser.addAdministratorsToDatabase(parser.parseAdministrators());
      //  parser.printAdministratorsDatabase();

        parser.addSubdivisionsToDatabase(parser.parseSubdivisions());
     //   parser.printSubdivisionsDatabase();

        parser.addProceedsToDatabase(parser.parseProceeds());
     //   parser.printProceedDatabase();

        parser.addSalariesToDatabase(parser.parseSalaries());
     //   parser.printSalariesDatabase();

        parser.addWorkshiftsToDatabase(parser.parseWorkshifts());
     //   parser.printWorkshiftsDatabase();

        System.exit(0);
    }
}
