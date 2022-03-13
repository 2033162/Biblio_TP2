package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Employe;
import ca.cal.bibliotheque.persistance.JPA.EmployeDao;

public class ServiceEmploye {

    private EmployeDao dao;

    public ServiceEmploye(EmployeDao dao) {
        this.dao = dao;
    }

    public long createEmploye(Employe employe) {
        return dao.createEmploye(employe);
    }

    public void updateEmploye(Employe employe) {
        dao.updateEmploye(employe);
    }

    public void removeEmploye(Employe employe) {
        dao.removeEmploye(employe);
    }

    public Employe getEmploye(long employeID) {
        return dao.getEmploye(employeID);
    }
}
