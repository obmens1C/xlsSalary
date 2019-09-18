package hibernate;

import dao.*;
import daoImpl.*;


public class Factory {
    private static Factory instance = null;
    private static AdministratorDAO administratorDAO = null;
    private static SubdivisionDAO subdivisionDAO = null;

    //private static ManagerDAO managerDAO = null;
    /*private static CustomerDAO customerDAO = null;
    private static OrderDAO orderDAO = null;
    private static PaymentDAO paymentDAO = null;
    private static CurrencyDAO currencyDAO = null;*/

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public AdministratorDAO getAdministratorDAO() {
        if (administratorDAO == null) {
            administratorDAO = new AdministratorDAOImpl();
        }
        return administratorDAO;
    }
    /*public ManagerDAO getManagerDAO() {
        if (managerDAO == null) {
            managerDAO = new ManagerDAOImpl();
        }
        return managerDAO;
    }*/

    public SubdivisionDAO getSubdivisionDAO() {
        if (subdivisionDAO == null) {
            subdivisionDAO = new SubdivisionDAOImpl();
        }

        return subdivisionDAO;
    }

   /* public OrderDAO getOrderDAO() {
        if (orderDAO == null) {
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }

    public PaymentDAO getPaymentDAO() {
        if (paymentDAO == null) {
            paymentDAO = new PaymentDAOImpl();
        }
        return paymentDAO;
    }

    public CurrencyDAO getCurrencyDAO() {
        if (currencyDAO == null) {
            currencyDAO = new CurrencyDAOImpl();
        }
        return currencyDAO;
    }*/
}