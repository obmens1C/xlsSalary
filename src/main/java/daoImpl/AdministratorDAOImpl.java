package daoImpl;

import dao.AdministratorDAO;
import entity.Administrator;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

public class AdministratorDAOImpl implements AdministratorDAO{
    private Session session;

    public AdministratorDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addAdministrator(Administrator administrator) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(administrator);
        session.getTransaction().commit();
    }

    @Override
    public void updateAdministrator(Administrator administrator) throws SQLException, Exception {
        session.beginTransaction();
        session.update(administrator);
        session.getTransaction().commit();
    }

    @Override
    public void mergeAdministrator(Administrator administrator) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(administrator);
        session.getTransaction().commit();
    }

    @Override
    public Administrator getAdministratorById(String id) throws SQLException, Exception {
        Administrator administrator = null;
        administrator = (Administrator) session.get(Administrator.class, id);
        return administrator;
    }

    @Override
    public Collection<Administrator> getAllAdministrators() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Administrator> criteriaQuery = criteriaBuilder.createQuery(Administrator.class);
        Root<Administrator> administratorRoot = criteriaQuery.from(Administrator.class);
        criteriaQuery.select(administratorRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteAdministrator(Administrator administrator) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(administrator);
        session.getTransaction().commit();
    }
}
