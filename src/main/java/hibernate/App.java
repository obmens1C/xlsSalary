package hibernate;

import entity.Currency;
import entity.Customer;
import entity.Manager;
import entity.Order;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class App {
    public void parseXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src\\main\\resources\\test.xml"));

       /* List<Currency> currencies = new ArrayList<>();

        NodeList currencyNodeList = document.getDocumentElement().getElementsByTagName("currency");
        for (int i = 0; i < currencyNodeList.getLength(); i++) {
            Node currencyNode = currencyNodeList.item(i);
            NamedNodeMap currencyNodeMap = currencyNode.getAttributes();
            String currencyUID = currencyNodeMap.getNamedItem("id").getNodeValue();
            String currencyName = currencyNodeMap.getNamedItem("name").getNodeValue();
            int currencyValue = Integer.parseInt(currencyNodeMap.getNamedItem("value").getNodeValue().replaceAll("[\\s|\\u00A0]+", ""));
            Currency currency = new Currency(currencyUID, currencyName, currencyValue);
            currencies.add(currency);
        }

        addChangeCurrencies(currencies);

        */List<Manager> managers = new ArrayList<>();

        NodeList managerNodeList = document.getDocumentElement().getElementsByTagName("manager");
        for (int i = 0; i < managerNodeList.getLength(); i++) {
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

       /* List<Customer> customers = new ArrayList<>();

        NodeList customerNodeList = document.getDocumentElement().getElementsByTagName("customer");
        for (int i = 0; i < customerNodeList.getLength(); i++) {
            Node customerNode = customerNodeList.item(i);
            NamedNodeMap customerNodeMap = customerNode.getAttributes();
            String customerUID = customerNodeMap.getNamedItem("id").getNodeValue();
            String customerName = customerNodeMap.getNamedItem("name").getNodeValue();
            int customerPercent = Integer.parseInt(customerNodeMap.getNamedItem("percent").getNodeValue());
            Customer customer = new Customer(customerUID, customerName, customerPercent);
            customers.add(customer);
        }

        addChangeCustomers(customers);

        List<Order> orders = new ArrayList<>();
        NodeList orderNodeList = document.getDocumentElement().getElementsByTagName("order");
        for (int i = 0; i < orderNodeList.getLength(); i++) {
            Node orderNode = orderNodeList.item(i);
            NamedNodeMap orderNodeMap = orderNode.getAttributes();
            String orderUID = orderNodeMap.getNamedItem("id").getNodeValue();
            String orderNumber = orderNodeMap.getNamedItem("number").getNodeValue();
            LocalDate orderDate = LocalDate.parse(orderNodeMap.getNamedItem("date").getNodeValue());
            String orderCustomerId = orderNodeMap.getNamedItem("customerid").getNodeValue();
            Customer orderCustomer = getCustomerById(orderCustomerId);
            String orderManagerId = orderNodeMap.getNamedItem("managerid").getNodeValue();
            Manager orderManager = getManagerById(orderManagerId);
            int orderSum = Integer.parseInt(orderNodeMap.getNamedItem("sum").getNodeValue().replaceAll("[\\s|\\u00A0]+", ""));
            String orderCurrencyId = orderNodeMap.getNamedItem("curencyid").getNodeValue();
            Currency orderCurrency = getCurrencyById(orderCurrencyId);
            Order order = new Order(orderUID, orderNumber, orderDate, orderCustomer, orderManager, orderSum, orderCurrency);
            orders.add(order);
        }

        addChangeOrders(orders);
    }

    Customer getCustomerById(String customreId) {
        Session session = null;

        Customer customer = null;
        try {
            customer = Factory.getInstance().getCustomerDAO().getCustomerById(customreId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }

    Manager getManagerById(String managerId) {
        Session session = null;

        Manager manager = null;
        try {
            manager = Factory.getInstance().getManagerDAO().getManagerById(managerId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return manager;
    }

    Currency getCurrencyById(String currencyId) {
        Session session = null;

        Currency currency = null;
        try {
            currency = Factory.getInstance().getCurrencyDAO().getCurrencyById(currencyId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return currency;
    }

    public void addChangeCurrencies(List<Currency> currencies) {
        Session session = null;

        for (Currency currency : currencies) {
            try {
                Factory.getInstance().getCurrencyDAO().addCurrency(currency);
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

    public void addChangeOrders(List<Order> orders) {
        Session session = null;

        for (Order order : orders) {
            try {
                Factory.getInstance().getOrderDAO().addOrder(order);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }*/
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
/*
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

    public void printAllCurrencies() {
        Session session = null;
        try {
            Collection<Currency> currencies = Factory.getInstance().getCurrencyDAO().getAllCurrences();
            Iterator<Currency> currencyIterator = currencies.iterator();
            System.out.println("list of currencies:");
            while (currencyIterator.hasNext()) {
                Currency currency = (Currency) currencyIterator.next();
                System.out.println(currency);
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
    }*/

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
/*
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

    public void printAllOrders() {
        Session session = null;
        try {
            Collection<Order> orders = Factory.getInstance().getOrderDAO().getAllOrders();
            Iterator<Order> orderIterator = orders.iterator();
            System.out.println("list of orders:");
            while (orderIterator.hasNext()) {
                Order order = (Order) orderIterator.next();
                System.out.println(order);
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
    }*/
}