package hibernate;

import entity.*;
import org.hibernate.Session;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParserFrom1C {
    private Document document = null;

    public ParserFrom1C() {
        try {
            loadDocumentXML();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDocumentXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.parse(new File("src\\main\\resources\\test.xml"));
    }


    public List<Administrator> parseAdministrators() {
        List<Administrator> administrators = new ArrayList<>();

        NodeList administratorNodeList = document.getDocumentElement().getElementsByTagName("Administrator");
        for (int i = 0; i < administratorNodeList.getLength(); i++) {
            Node administratorNode = administratorNodeList.item(i);
            NamedNodeMap administratorNodeMap = administratorNode.getAttributes();
            String administratorUID = administratorNodeMap.getNamedItem("id").getNodeValue();
            String administratorName = administratorNodeMap.getNamedItem("name").getNodeValue();
            Administrator administrator = new Administrator(administratorUID, administratorName);
            administrators.add(administrator);
        }
        return administrators;
    }

    public void addAdministratorsToDatabase(List<Administrator> administrators) {
        Session session = null;

        for (Administrator administrator : administrators) {
            try {
                Factory.getInstance().getAdministratorDAO().addAdministrator(administrator);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    private Administrator getAdministratorById(String administratorId) {
        Session session = null;

        Administrator administrator = null;
        try {
            administrator = Factory.getInstance().getAdministratorDAO().getAdministratorById(administratorId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return administrator;
    }

    public void printAdministratorsDatabase() {
        Session session = null;
        try {
            Collection<Administrator> administrators = Factory.getInstance().getAdministratorDAO().getAllAdministrators();
            Iterator<Administrator> administratorIterator = administrators.iterator();
            System.out.println("list of administrators:");
            while (administratorIterator.hasNext()) {
                Administrator administrator = (Administrator) administratorIterator.next();
                System.out.println(administrator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public List<Subdivision> parseSubdivisions() {
        List<Subdivision> subdivisions = new ArrayList<>();

        NodeList subdivisionNodeList = document.getDocumentElement().getElementsByTagName("Subdivision");
        for (int i = 0; i < subdivisionNodeList.getLength(); i++) {
            Node subdivisionNode = subdivisionNodeList.item(i);
            NamedNodeMap subdivisionNodeMap = subdivisionNode.getAttributes();
            String subdivisionUID = subdivisionNodeMap.getNamedItem("id").getNodeValue();
            String subdivisionName = subdivisionNodeMap.getNamedItem("name").getNodeValue();
            Subdivision subdivision = new Subdivision(subdivisionUID, subdivisionName);
            subdivisions.add(subdivision);
        }
        return subdivisions;
    }

    public void addSubdivisionsToDatabase(List<Subdivision> subdivisions) {
        Session session = null;

        for (Subdivision subdivision : subdivisions) {
            try {
                Factory.getInstance().getSubdivisionDAO().addSubdivision(subdivision);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    private Subdivision getSubdivisionById(String subdivisionId) {
        Session session = null;

        Subdivision subdivision = null;
        try {
            subdivision = Factory.getInstance().getSubdivisionDAO().getSubdivisionById(subdivisionId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return subdivision;
    }

    public void printSubdivisionsDatabase() {
        Session session = null;
        try {
            Collection<Subdivision> subdivisions = Factory.getInstance().getSubdivisionDAO().getAllSubdivisions();
            Iterator<Subdivision> subdivisionIterator = subdivisions.iterator();
            System.out.println("list of subdivisions:");
            while (subdivisionIterator.hasNext()) {
                Subdivision subdivision = (Subdivision) subdivisionIterator.next();
                System.out.println(subdivision);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public List<Proceed> parseProceeds() {
        List<Proceed> proceeds = new ArrayList<>();

        NodeList proceedNodeList = document.getDocumentElement().getElementsByTagName("Proceed");
        for (int i = 0; i < proceedNodeList.getLength(); i++) {
            Node proceedNode = proceedNodeList.item(i);
            NamedNodeMap proceedNodeMap = proceedNode.getAttributes();
            DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate proceedDate = LocalDate.parse(proceedNodeMap.getNamedItem("date").getNodeValue(), customFormatter);
            String subdivisionId = proceedNodeMap.getNamedItem("subdivision_id").getNodeValue();
            Subdivision proceedSubdivision = getSubdivisionById(subdivisionId);
            String textSalarySum = proceedNodeMap.getNamedItem("sum").getNodeValue().replaceAll("[\\s|\\u00A0]+", "");
            int proceedSum  = Integer.parseInt(textSalarySum.replace(",", "."));
            String proceedUID = proceedNodeMap.getNamedItem("subdivision_id").getNodeValue() + textSalarySum;
            Proceed proceed = new Proceed(proceedUID, proceedDate, proceedSubdivision, proceedSum);
            proceeds.add(proceed);
        }
        return proceeds;
    }

    public void addProceedsToDatabase(List<Proceed> proceeds) {
        Session session = null;

        for (Proceed proceed : proceeds) {
            try {
                Factory.getInstance().getProceedDAO().addProceed(proceed);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    private Proceed getProceedById(String proceedId) {
        Session session = null;

        Proceed proceed = null;
        try {
            proceed = Factory.getInstance().getProceedDAO().getProceedById(proceedId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return proceed;
    }

    public void printProceedDatabase() {
        Session session = null;
        try {
            Collection<Proceed> proceeds = Factory.getInstance().getProceedDAO().getAllProceeds();
            Iterator<Proceed> proceedIterator = proceeds.iterator();
            System.out.println("list of proceeds:");
            while (proceedIterator.hasNext()) {
                Proceed proceed = (Proceed) proceedIterator.next();
                System.out.println(proceed);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public List<Salary> parseSalaries() {
        List<Salary> salaries = new ArrayList<>();
        NodeList salaryNodeList = document.getDocumentElement().getElementsByTagName("Salary");
        for (int i = 0; i < salaryNodeList.getLength(); i++) {
            Node salaryNode = salaryNodeList.item(i);
            NamedNodeMap salaryNodeMap = salaryNode.getAttributes();

            DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate salaryDate = LocalDate.parse(salaryNodeMap.getNamedItem("date").getNodeValue(), customFormatter);

            String subdivisionId = salaryNodeMap.getNamedItem("subdivision_id").getNodeValue();
            Subdivision salarySubdivision = getSubdivisionById(subdivisionId);
           /* if (salarySubdivision == null) {
                salarySubdivision = new Subdivision(subdivisionId, "not_found");
                List<Subdivision> newSubdivisions = new ArrayList<>();
                newSubdivisions.add(salarySubdivision);
                addSubdivisionsToDatabase(newSubdivisions);
            }*/

            String textSalaryAmount = salaryNodeMap.getNamedItem("amount").getNodeValue().replaceAll("[\\s|\\u00A0]+", "");
            Double amount  = Double.parseDouble(textSalaryAmount.replace(",", "."));
            String salaryUID = salaryNodeMap.getNamedItem("subdivision_id").getNodeValue() + salaryDate.toString().replace(".","");
            salaries.add(new Salary(salaryUID, salaryDate, salarySubdivision, amount));
        }
        return salaries;
    }

    public void addSalariesToDatabase(List<Salary> salaries) {
        Session session = null;

        for (Salary salary : salaries) {
            try {
                Factory.getInstance().getSalaryDAO().addSalary(salary);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    private Salary getSalaryById(String salaryId) {
        Session session = null;

        Salary salary = null;
        try {
            salary = Factory.getInstance().getSalaryDAO().getSalaryById(salaryId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return salary;
    }

    public void printSalariesDatabase() {
        Session session = null;
        try {
            Collection<Salary> salaries = Factory.getInstance().getSalaryDAO().getAllSalaries();
            Iterator<Salary> salaryIterator = salaries.iterator();
            System.out.println("list of salaries:");
            while (salaryIterator.hasNext()) {
                Salary salary = (Salary) salaryIterator.next();
                System.out.println(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }


    public List<Workshift> parseWorkshifts() {
        List<Workshift> workshifts = new ArrayList<>();

        NodeList workshiftNodeList = document.getDocumentElement().getElementsByTagName("Workshift");
        for (int i = 0; i <workshiftNodeList.getLength(); i++) {
            Node workshiftNode = workshiftNodeList.item(i);
            NamedNodeMap workshiftNodeMap = workshiftNode.getAttributes();

            String subdivisionId = workshiftNodeMap.getNamedItem("subdivision").getNodeValue();
            Subdivision workshiftSubdivision = getSubdivisionById(subdivisionId);
          /*  if (workshiftSubdivision == null) {
                workshiftSubdivision = new Subdivision(subdivisionId, "not_found");
                List<Subdivision> newSubdivisions = new ArrayList<>();
                newSubdivisions.add(workshiftSubdivision);
                addSubdivisionsToDatabase(newSubdivisions);
            }*/

            DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm:ss");
            LocalDateTime workshiftOpenningDate = LocalDateTime.parse(workshiftNodeMap.getNamedItem("openningdate").getNodeValue(), customFormatter);

            LocalDateTime workshiftClousingDate = LocalDateTime.parse(workshiftNodeMap.getNamedItem("clousingdate").getNodeValue(), customFormatter);

            String employeeId = workshiftNodeMap.getNamedItem("employee").getNodeValue();
            Administrator workshiftAdministrator = getAdministratorById(employeeId);
            /*if (workshiftSubdivision == null) {
                workshiftSubdivision = new Subdivision(subdivisionId, "not_found");
                List<Subdivision> newSubdivisions = new ArrayList<>();
                newSubdivisions.add(workshiftSubdivision);
                addSubdivisionsToDatabase(newSubdivisions);
            }*/

            String workshiftStatus = workshiftNodeMap.getNamedItem("status").getNodeValue();

            workshifts.add(new Workshift(workshiftSubdivision, workshiftOpenningDate, workshiftClousingDate, workshiftAdministrator, workshiftStatus));
        }

        return workshifts;
    }

    public void addWorkshiftsToDatabase(List<Workshift> workshifts) {
        Session session = null;

        for (Workshift workshift : workshifts) {
            try {
                Factory.getInstance().getWorkshiftDAO().addWorkshift(workshift);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    public Workshift getWorkshiftById(String workshiftId) {
        Session session = null;

        Workshift workshift = null;
        try {
            workshift = Factory.getInstance().getWorkshiftDAO().getWorkshiftById(workshiftId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return workshift;
    }

    public void printWorkshiftsDatabase() {
        Session session = null;
        try {
            Collection<Workshift> workshifts = Factory.getInstance().getWorkshiftDAO().getAllWorkshifts();
            Iterator<Workshift> workshiftIterator = workshifts.iterator();
            System.out.println("list of workshifts:");
            while (workshiftIterator.hasNext()) {
                Workshift workshift = (Workshift) workshiftIterator.next();
                System.out.println(workshift);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
