package dao;

import entity.Subdivision;

import java.sql.SQLException;
import java.util.Collection;

public interface SubdivisionDAO {
    public void addSubdivision(Subdivision subdivision) throws SQLException, Exception;
    public void updateSubdivision(Subdivision subdivision) throws SQLException, Exception;
    public void mergeSubdivision(Subdivision subdivision) throws SQLException, Exception;
    public Subdivision getSubdivisionById(String id) throws SQLException, Exception;
    public Collection<Subdivision> getAllSubdivisions() throws SQLException, Exception;
    public void deleteSubdivision(Subdivision subdivision) throws SQLException, Exception;
}
