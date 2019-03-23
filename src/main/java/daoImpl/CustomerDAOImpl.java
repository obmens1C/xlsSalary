package daoImpl;

import dao.CustomerDAO;
import entity.Customer;
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

public class CustomerDAOImpl implements CustomerDAO{
    private Session session;

    public CustomerDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException, Exception {
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException, Exception {
        session.beginTransaction();
        session.update(customer);
        session.getTransaction().commit();
    }

    @Override
    public Customer getCustomerById(Long id) throws SQLException, Exception {
        Customer customer = null;
        // manager = (Manager) Session.load(Manager.class, id);
        customer = (Customer) session.load(Customer.class, id);
        return customer;
    }

    @Override
    public Collection<Customer> getAllCustomers() throws SQLException, Exception {
        List<Customer> customers = session.createCriteria(Customer.class).list();
        return customers;
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
    }
}
