package daoImpl;

import dao.WorkshiftDAO;
import entity.Workshift;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

public class WorkshiftDAOImpl implements WorkshiftDAO{
    private Session session;

    public WorkshiftDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addWorkshift(Workshift workshift) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(workshift);
        session.getTransaction().commit();
    }

    @Override
    public void updateWorkshift(Workshift workshift) throws SQLException, Exception {
        session.beginTransaction();
        session.update(workshift);
        session.getTransaction().commit();
    }

    @Override
    public void mergeWorkshift(Workshift workshift) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(workshift);
        session.getTransaction().commit();
    }

    @Override
    public Workshift getWorkshiftById(String id) throws SQLException, Exception {
        Workshift workshift = null;
        workshift = (Workshift) session.get(Workshift.class, id);
        return workshift;
    }

    @Override
    public Collection<Workshift> getAllWorkshifts() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Workshift> criteriaQuery = criteriaBuilder.createQuery(Workshift.class);
        Root<Workshift> workshiftRoot = criteriaQuery.from(Workshift.class);
        criteriaQuery.select(workshiftRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteWorkshift(Workshift workshift) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(workshift);
        session.getTransaction().commit();
    }
}
