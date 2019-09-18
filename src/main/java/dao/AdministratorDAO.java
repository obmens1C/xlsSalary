package dao;

import entity.Administrator;
import java.sql.SQLException;
import java.util.Collection;

public interface AdministratorDAO {
    public void addAdministrator(Administrator administrator) throws SQLException, Exception;
    public void updateAdministrator(Administrator administrator) throws SQLException, Exception;
    public void mergeAdministrator(Administrator administrator) throws SQLException, Exception;
    public Administrator getAdministratorById(String id) throws SQLException, Exception;
    public Collection<Administrator> getAllAdministrators() throws SQLException, Exception;
    public void deleteAdministrator(Administrator administrator) throws SQLException, Exception;
}
