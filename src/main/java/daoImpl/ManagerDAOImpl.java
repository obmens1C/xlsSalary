package daoImpl;

import dao.ManagerDAO;
import entity.Manager;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

@Deprecated
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
    public Manager getManagerById(String id) throws SQLException, Exception {
        Manager manager = null;
        manager = (Manager) session.get(Manager.class, id);
        return manager;
    }

    @Override
    public Collection<Manager> getAllManagers() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Manager> criteriaQuery = criteriaBuilder.createQuery(Manager.class);
        Root<Manager> managerRoot = criteriaQuery.from(Manager.class);
        criteriaQuery.select(managerRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteManager(Manager manager) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(manager);
        session.getTransaction().commit();
    }
}
