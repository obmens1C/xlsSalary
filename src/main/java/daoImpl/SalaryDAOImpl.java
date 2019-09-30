package daoImpl;

import dao.SalaryDAO;
import entity.Salary;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

public class SalaryDAOImpl implements SalaryDAO{
    private Session session;

    public SalaryDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addSalary(Salary salary) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(salary);
        session.getTransaction().commit();
    }

    @Override
    public void updateSalary(Salary salary) throws SQLException, Exception {
        session.beginTransaction();
        session.update(salary);
        session.getTransaction().commit();
    }

    @Override
    public void mergeSalary(Salary salary) throws SQLException, Exception {
        session.beginTransaction();
        session.merge(salary);
        session.getTransaction().commit();
    }

    @Override
    public Salary getSalaryById(String id) throws SQLException, Exception {
        Salary salary = null;
        salary = (Salary) session.get(Salary.class, id);
        return salary;
    }

    @Override
    public Collection<Salary> getAllSalaries() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Salary> criteriaQuery = criteriaBuilder.createQuery(Salary.class);
        Root<Salary> salaryRoot = criteriaQuery.from(Salary.class);
        criteriaQuery.select(salaryRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteSalary(Salary salary) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(salary);
        session.getTransaction().commit();
    }
}

