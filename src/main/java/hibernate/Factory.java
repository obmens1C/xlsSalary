package hibernate;

import dao.ManagerDAO;
import daoImpl.ManagerDAOImpl;

public class Factory {
    private static Factory instance = null;
    private static ManagerDAO managerDAO = null;

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
}