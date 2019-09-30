package dao;

import entity.Currency;
import java.sql.SQLException;
import java.util.Collection;

@Deprecated
public interface CurrencyDAO {
    public void addCurrency(Currency currency) throws SQLException, Exception;
    public void updateCurrency(Currency currency) throws SQLException, Exception;
    public Currency getCurrencyById(String id) throws SQLException, Exception;
    public Collection<Currency> getAllCurrences() throws SQLException, Exception;
    public void deleteCurrency(Currency currency) throws SQLException, Exception;
}
