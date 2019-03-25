package hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import entity.Manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    public void createManagers() {
        Session session = null;
        List<Manager> managers = new ArrayList<>();
        Manager Kolya = new Manager("Kolya", 20000, 6);
        Manager Urii = new Manager("Urii", 20000, 6);
        managers.add(Kolya);
        managers.add(Urii);
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