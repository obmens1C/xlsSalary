package daoImpl;

import dao.ProceedDAO;
import entity.Proceed;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

public class ProceedDAOImpl implements ProceedDAO{
    private Session session;

    public ProceedDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addProceed(Proceed proceed) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(proceed);
        session.getTransaction().commit();
    }

    @Override
    public void updateProceed(Proceed proceed) throws SQLException, Exception {
        session.beginTransaction();
        session.update(proceed);
        session.getTransaction().commit();
    }

    @Override
    public void mergeProceed(Proceed proceed) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(proceed);
        session.getTransaction().commit();
    }

    @Override
    public Proceed getProceedById(String id) throws SQLException, Exception {
        Proceed proceed = null;
        proceed = (Proceed) session.get(Proceed.class, id);
        return proceed;
    }

    @Override
    public Collection<Proceed> getAllProceeds() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Proceed> criteriaQuery = criteriaBuilder.createQuery(Proceed.class);
        Root<Proceed> proceedRoot = criteriaQuery.from(Proceed.class);
        criteriaQuery.select(proceedRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteProceed(Proceed proceed) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(proceed);
        session.getTransaction().commit();
    }
}
