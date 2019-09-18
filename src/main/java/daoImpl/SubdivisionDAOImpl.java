package daoImpl;

import dao.SubdivisionDAO;
import entity.Subdivision;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class SubdivisionDAOImpl implements SubdivisionDAO {
    private Session session;

    public SubdivisionDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addSubdivision(Subdivision subdivision) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(subdivision);
        session.getTransaction().commit();
    }

    @Override
    public void updateSubdivision(Subdivision subdivision) throws SQLException, Exception {
        session.beginTransaction();
        session.update(subdivision);
        session.getTransaction().commit();
    }

    @Override
    public void mergeSubdivision(Subdivision subdivision) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(subdivision);
        session.getTransaction().commit();
    }

    @Override
    public Subdivision getSubdivisionById(String id) throws SQLException, Exception {
        Subdivision subdivision = null;
        subdivision = (Subdivision) session.get(Subdivision.class, id);
        return subdivision;
    }

    @Override
    public Collection<Subdivision> getAllSubdivisions() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Subdivision> criteriaQuery = criteriaBuilder.createQuery(Subdivision.class);
        Root<Subdivision> subdivisionRoot = criteriaQuery.from(Subdivision.class);
        criteriaQuery.select(subdivisionRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteSubdivision(Subdivision subdivision) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(subdivision);
        session.getTransaction().commit();
    }
}
