package daoImpl;

import dao.PaymentDAO;
import entity.Payment;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {
    private Session session;

    public PaymentDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addPayment(Payment payment) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(payment);
        session.getTransaction().commit();
    }

    @Override
    public void updatePayment(Payment payment) throws SQLException, Exception {
        session.beginTransaction();
        session.update(payment);
        session.getTransaction().commit();
    }

    @Override
    public Payment getPaymentById(String id) throws SQLException, Exception {
        Payment payment = null;
        payment = (Payment) session.load(Payment.class, id);
        return payment;
    }

    @Override
    public Collection<Payment> getAllPayments() throws SQLException, Exception {
        List<Payment> payments = session.createCriteria(Payment.class).list();
        return payments;
    }

    @Override
    public void deletePayment(Payment payment) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(payment);
        session.getTransaction().commit();
    }
}
