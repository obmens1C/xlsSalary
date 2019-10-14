package hibernate;

import dao.*;
import daoImpl.*;


public class Factory {
    private static Factory instance = null;
    private static AdministratorDAO administratorDAO = null;
    private static SubdivisionDAO subdivisionDAO = null;
    private static SalaryDAO salaryDAO = null;
    private static WorkshiftDAO workshiftDAO = null;
    private static ProceedDAO proceedDAO = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public AdministratorDAO getAdministratorDAO() {
        if (administratorDAO == null) {
            administratorDAO = new AdministratorDAOImpl();
        }
        return administratorDAO;
    }

    public WorkshiftDAO getWorkshiftDAO() {
        if (workshiftDAO == null) {
            workshiftDAO = new WorkshiftDAOImpl();
        }
        return workshiftDAO;
    }

    public SubdivisionDAO getSubdivisionDAO() {
        if (subdivisionDAO == null) {
            subdivisionDAO = new SubdivisionDAOImpl();
        }

        return subdivisionDAO;
    }

    public SalaryDAO getSalaryDAO() {
        if (salaryDAO == null) {
            salaryDAO = new SalaryDAOImpl();
        }
        return salaryDAO;
    }

    public ProceedDAO getProceedDAO() {
        if (proceedDAO == null) {
            proceedDAO = new ProceedDAOImpl();
        }
        return proceedDAO;
    }
}