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
            int subdivisionProceeds = Integer.parseInt(subdivisionNodeMap.getNamedItem("proceeds").getNodeValue().replaceAll("[\\s|\\u00A0]+", ""));
            Subdivision subdivision = new Subdivision(subdivisionUID, subdivisionName, subdivisionProceeds);
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


    public List<Salary> parseSalaries() {
        List<Salary> salaries = new ArrayList<>();
        NodeList salaryNodeList = document.getDocumentElement().getElementsByTagName("Salary");
        for (int i = 0; i < salaryNodeList.getLength(); i++) {
            Node salaryNode = salaryNodeList.item(i);
            NamedNodeMap salaryNodeMap = salaryNode.getAttributes();

            DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy H:mm:ss");
            LocalDateTime salaryDate = LocalDateTime.parse(salaryNodeMap.getNamedItem("date").getNodeValue(), customFormatter);

            String subdivisionId = salaryNodeMap.getNamedItem("subdivision_id").getNodeValue();
            Subdivision salarySubdivision = getSubdivisionById(subdivisionId);
            if (salarySubdivision == null) {
                salarySubdivision = new Subdivision(subdivisionId, "not_found");
                List<Subdivision> newSubdivisions = new ArrayList<>();
                newSubdivisions.add(salarySubdivision);
                addSubdivisionsToDatabase(newSubdivisions);
            }

            String textSalaryAmount = salaryNodeMap.getNamedItem("amount").getNodeValue().replaceAll("[\\s|\\u00A0]+", "");
            Double amount  = Double.parseDouble(textSalaryAmount.replace(",", "."));
            salaries.add(new Salary(salaryDate, salarySubdivision, amount));
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
        //TODO

        return workshifts;
    }

    public void addWorkshiftsToDataBase(List<Workshift> workshifts) {
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
