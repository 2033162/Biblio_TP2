package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.CD;
import ca.cal.bibliotheque.model.DVD;
import ca.cal.bibliotheque.model.Employe;
import ca.cal.bibliotheque.model.Livre;
import ca.cal.bibliotheque.persistance.CRUD.JDBCEmployeH2;
import ca.cal.bibliotheque.persistance.JPA.DocumentsDao;
import ca.cal.bibliotheque.persistance.JPA.EmployeDao;

public class ServiceEmploye {

    private EmployeDao dao;

    public ServiceEmploye(EmployeDao dao) {
        this.dao = dao;
    }

    public long createEmploye(Employe employe) {
        return dao.createEmploye(employe);
    }

    public Employe getEmploye(long employeID) {
        return dao.getEmploye(employeID);
    }

    /*public void enregistrer(Employe employe) {
        new JDBCEmployeH2().enregistrer(employe);
    }

    public void modification(Employe employe) {
        new JDBCEmployeH2().modification(employe);
    }

    public void suppression(Employe employe) {
        new JDBCEmployeH2().suppression(employe);
    }

    public Employe getEmploye(long employeId) {
        return new JDBCEmployeH2().getEmploye(employeId);
    }*/
}
