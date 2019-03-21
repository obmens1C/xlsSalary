package hibernate;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import entity.Manager;

import org.hibernate.Session;

public class App {
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
}