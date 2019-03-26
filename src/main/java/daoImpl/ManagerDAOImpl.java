package daoImpl;

import dao.ManagerDAO;
import entity.Manager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ManagerDAOImpl implements ManagerDAO{
    private Session session;

    public ManagerDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(manager);
        session.getTransaction().commit();
    }

    @Override
    public void updateManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.update(manager);
        session.getTransaction().commit();
    }

    @Override
    public void mergeManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(manager);
        session.getTransaction().commit();
    }

    @Override
    public Manager getManagerById(Long id) throws SQLException, Exception {
        Manager manager = null;
        manager = (Manager) session.load(Manager.class, id);
        return manager;
    }

    @Override
    public Collection<Manager> getAllManagers() throws SQLException, Exception {
        List<Manager> managers = session.createCriteria(Manager.class).list();
        //https://ru.stackoverflow.com/questions/560711/%D0%9A%D0%B0%D0%BA-%D0%BE%D0%B1%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-%D1%82%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE-%D0%BD%D0%B5%D1%81%D0%BA%D0%BE%D0%BB%D1%8C%D0%BA%D0%BE-%D0%BF%D0%BE%D0%BB%D0%B5%D0%B9-%D0%B2-%D1%82%D0%B0%D0%B1%D0%BB%D0%B8%D1%86%D0%B5-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8F-jpa
        return managers;
    }

    @Override
    public void deleteManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(manager);
        session.getTransaction().commit();
    }
}
