package daoImpl;

import dao.SubdivisionDAO;
import entity.Subdivision;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class SubdivisionDAOImpl implements SubdivisionDAO {
    private Session session;

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
    public Subdivision getSubdivisionById(String id) throws SQLException, Exception {
        Subdivision subdivision = null;
        subdivision = (Subdivision) session.load(Subdivision.class, id);
        return subdivision;
    }

    @Override
    public Collection<Subdivision> getAllSubdivisions() throws SQLException, Exception {
        List<Subdivision> subdivisions = session.createCriteria(Subdivision.class).list();
        return subdivisions;
    }

    @Override
    public void deleteSubdivision(Subdivision subdivision) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(subdivision);
        session.getTransaction().commit();
    }
}
