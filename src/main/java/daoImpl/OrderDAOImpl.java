package daoImpl;

import dao.OrderDAO;
import entity.Order;
import org.hibernate.Session;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Deprecated
public class OrderDAOImpl implements OrderDAO {

    private Session session;

    public OrderDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public void addOrder(Order order) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(order);
        session.getTransaction().commit();
    }

    @Override
    public void updateOrder(Order order) throws SQLException, Exception {
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
    }

    @Override
    public Order getOrderById(String id) throws SQLException, Exception {
        Order order = null;
        order = (Order) session.get(Order.class, id);
        return order;
    }

    @Override
    public Collection<Order> getAllOrders() throws SQLException, Exception {
        List<Order> orders = session.createCriteria(Order.class).list();
        return orders;
    }

    @Override
    public void deleteOrder(Order order) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
    }
}
