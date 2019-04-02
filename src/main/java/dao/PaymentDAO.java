package dao;

import entity.Payment;
import java.sql.SQLException;
import java.util.Collection;

public interface PaymentDAO {
    public void addPayment(Payment payment) throws SQLException, Exception;
    public void updatePayment(Payment payment) throws SQLException, Exception;
    public Payment getPaymentById(String id) throws SQLException, Exception;
    public Collection<Payment> getAllPayments() throws SQLException, Exception;
    public void deletePayment(Payment payment) throws SQLException, Exception;
}
