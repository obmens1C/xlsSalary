package hibernate;

import dao.CustomerDAO;
import dao.ManagerDAO;
import dao.OrderDAO;
import daoImpl.ManagerDAOImpl;
import daoImpl.CustomerDAOImpl;


public class Factory {
    private static Factory instance = null;
    private static ManagerDAO managerDAO = null;
    private static CustomerDAO customerDAO = null;
    private static OrderDAO orderDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public ManagerDAO getManagerDAO() {
        if (managerDAO == null) {
            managerDAO = new ManagerDAOImpl();
        }
        return managerDAO;
    }

    public CustomerDAO getCustomerDAO() {
        if (customerDAO == null) {
            customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }

    public OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }
}