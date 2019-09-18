package dao;

import entity.Manager;
import java.sql.SQLException;
import java.util.Collection;

@Deprecated
public interface ManagerDAO {
    public void addManager(Manager manager) throws SQLException, Exception;
    public void updateManager(Manager manager) throws SQLException, Exception;
    public void mergeManager(Manager manager) throws SQLException, Exception;
    public Manager getManagerById(String id) throws SQLException, Exception;
    public Collection<Manager> getAllManagers() throws SQLException, Exception;
    public void deleteManager(Manager manager) throws SQLException, Exception;
}
