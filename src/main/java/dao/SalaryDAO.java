package dao;

import entity.Salary;

import java.sql.SQLException;
import java.util.Collection;

public interface SalaryDAO {
    public void addSalary(Salary salary) throws SQLException, Exception;
    public void updateSalary(Salary salary) throws SQLException, Exception;
    public void mergeSalary(Salary salary) throws SQLException, Exception;
    public Salary getSalaryById(String id) throws SQLException, Exception;
    public Collection<Salary> getAllSalaries() throws SQLException, Exception;
    public void deleteSalary(Salary salary) throws SQLException, Exception;
}
