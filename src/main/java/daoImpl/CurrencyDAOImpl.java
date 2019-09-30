package daoImpl;

import dao.CurrencyDAO;
import entity.Currency;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;
import java.util.Collection;

@Deprecated
public class CurrencyDAOImpl implements CurrencyDAO {
    private Session session;

    public CurrencyDAOImpl() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    @Override
    public void addCurrency(Currency currency) throws SQLException, Exception {
        session.beginTransaction();
        session.saveOrUpdate(currency);
        session.getTransaction().commit();
    }

    @Override
    public void updateCurrency(Currency currency) throws SQLException, Exception {
        session.beginTransaction();
        session.update(currency);
        session.getTransaction().commit();
    }

    @Override
    public Currency getCurrencyById(String id) throws SQLException, Exception {
        Currency currency = null;
        currency = (Currency) session.load(Currency.class, id);
        return currency;
    }

    @Override
    public Collection<Currency> getAllCurrences() throws SQLException, Exception {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Currency> criteriaQuery = criteriaBuilder.createQuery(Currency.class);
        Root<Currency> currencyRoot = criteriaQuery.from(Currency.class);
        criteriaQuery.select(currencyRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public void deleteCurrency(Currency currency) throws SQLException, Exception {
        session.beginTransaction();
        session.delete(currency);
        session.getTransaction().commit();
    }
}
