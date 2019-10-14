package dao;

import entity.Proceed;

import java.sql.SQLException;
import java.util.Collection;

public interface ProceedDAO {
    public void addProceed(Proceed proceed) throws SQLException, Exception;
    public void updateProceed(Proceed proceed) throws SQLException, Exception;
    public void mergeProceed(Proceed proceed) throws SQLException, Exception;
    public Proceed getProceedById(String id) throws SQLException, Exception;
    public Collection<Proceed> getAllProceeds() throws SQLException, Exception;
    public void deleteProceed(Proceed proceed) throws SQLException, Exception;
}
