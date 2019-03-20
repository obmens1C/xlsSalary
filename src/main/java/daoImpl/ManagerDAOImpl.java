package daoImpl;

import dao.ManagerDAO;
import entity.Manager;
import org.hibernate.Session;
import util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManagerDAOImpl implements ManagerDAO{
    private Session session;

    public ManagerDAOImpl() {
       // session = HibernateUtil.getSessionFactory().OpenSession();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.save(manager);
        session.getTransaction().commit();
    }

    @Override
    public void updateManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.update(manager);
        session.getTransaction().commit();
    }

    @Override
    public Manager getManagerById(Long id) throws SQLException, Exception {
        Manager manager = null;
       // manager = (Manager) Session.load(Manager.class, id);
        manager = (Manager) session.load(Manager.class, id);
        return manager;
    }

    @Override
    public Collection<Manager> getAllManagers() throws SQLException, Exception {
        List<Manager> managers = new ArrayList<>();
        managers = session.createCriteria(Manager.class).list();
        return managers;
    }

    @Override
    public void deleteManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(manager);
        session.getTransaction().commit();
    }
}
