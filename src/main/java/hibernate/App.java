package hibernate;

import entity.Customer;
import entity.Manager;
import org.hibernate.Session;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class App {
    public void parseXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src\\main\\resources\\test.xml"));

        List<Manager> managers = new ArrayList<>();

        NodeList managerNodeList = document.getDocumentElement().getElementsByTagName("manager");
        for (int i = 0; i <managerNodeList.getLength() ; i++) {
            Node managerNode = managerNodeList.item(i);
            NamedNodeMap managerNodeMap = managerNode.getAttributes();
            String managerUID = managerNodeMap.getNamedItem("id").getNodeValue();
            String managerName = managerNodeMap.getNamedItem("name").getNodeValue();
            int managerSalary = Integer.parseInt(managerNodeMap.getNamedItem("salary").getNodeValue().replaceAll("[\\s|\\u00A0]+", ""));
            int managerPercent = Integer.parseInt(managerNodeMap.getNamedItem("percent").getNodeValue());
            Manager manager = new Manager(managerUID, managerName, managerSalary, managerPercent);
            managers.add(manager);
        }

        addChangeManagers(managers);

        List<Customer> customers = new ArrayList<>();

        NodeList cusNodeList = document.getDocumentElement().getElementsByTagName("customer");
        for (int i = 0; i <cusNodeList.getLength() ; i++) {
            Node customerNode = managerNodeList.item(i);
            NamedNodeMap customerNodeMap = customerNode.getAttributes();
            String customerUID = customerNodeMap.getNamedItem("id").getNodeValue();
            String customerName = customerNodeMap.getNamedItem("name").getNodeValue();
            int customerPercent = Integer.parseInt(customerNodeMap.getNamedItem("percent").getNodeValue());
            Customer customer = new Customer(customerUID, customerName, customerPercent);
            customers.add(customer);
        }

        addChangeCustomers(customers);

    }

    public void addChangeManagers(List<Manager> managers) {
        Session session = null;

        for (Manager manager : managers) {
            try {
                Factory.getInstance().getManagerDAO().addManager(manager);
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

    public void addChangeCustomers(List<Customer> customers) {
        Session session = null;

        for (Customer customer : customers) {
            try {
                Factory.getInstance().getCustomerDAO().addCustomer(customer);
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

    public void printAllManagers() {
        Session session = null;
        try {
            Collection<Manager> managers = Factory.getInstance().getManagerDAO().getAllManagers();
            Iterator<Manager> managerIterator = managers.iterator();
            System.out.println("list of managers:");
            while (managerIterator.hasNext()) {
                Manager manager = (Manager) managerIterator.next();
                System.out.println("manager #" + manager.getId() + ", name is " + manager.getName() + ", salary:" + manager.getSalary() + ", percent:" + manager.getPercent());
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

    public void printAllCustomers() {
        Session session = null;
        try {
            Collection<Customer> customers = Factory.getInstance().getCustomerDAO().getAllCustomers();
            Iterator<Customer> customerIterator = customers.iterator();
            System.out.println("list of customers:");
            while (customerIterator.hasNext()) {
                Customer customer = (Customer) customerIterator.next();
                System.out.println(customer);
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