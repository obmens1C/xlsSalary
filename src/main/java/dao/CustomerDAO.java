package dao;

import entity.Customer;
import java.sql.SQLException;
import java.util.Collection;

public interface CustomerDAO {
    public void addCustomer(Customer customer) throws SQLException, Exception;
    public void updateCustomer(Customer customer) throws SQLException, Exception;
    public Customer getCustomerById(String id) throws SQLException, Exception;
    public Collection<Customer> getAllCustomers() throws SQLException, Exception;
    public void deleteCustomer(Customer customer) throws SQLException, Exception;
}
