package dao;

import entity.Workshift;

import java.sql.SQLException;
import java.util.Collection;

public interface WorkshiftDAO {
    public void addWorkshift(Workshift workshift) throws SQLException, Exception;
    public void updateWorkshift(Workshift workshift) throws SQLException, Exception;
    public void mergeWorkshift(Workshift workshift) throws SQLException, Exception;
    public Workshift getWorkshiftById(String id) throws SQLException, Exception;
    public Collection<Workshift> getAllWorkshifts() throws SQLException, Exception;
    public void deleteWorkshift(Workshift workshift) throws SQLException, Exception;
}
