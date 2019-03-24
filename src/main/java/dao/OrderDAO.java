package dao;

import entity.Order;
import java.sql.SQLException;
import java.util.Collection;

public interface OrderDAO {
    public void addOrder(Order order) throws SQLException, Exception;
    public void updateOrder(Order order) throws SQLException, Exception;
    public Order getOrderById(Long id) throws SQLException, Exception;
    public Collection<Order> getAllOrders() throws SQLException, Exception;
    public void deleteOrder(Order order) throws SQLException, Exception;
}
