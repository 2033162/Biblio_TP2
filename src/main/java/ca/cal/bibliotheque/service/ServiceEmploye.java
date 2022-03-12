package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Employe;
import ca.cal.bibliotheque.persistance.CRUD.JDBCEmployeH2;

public class ServiceEmploye {
    public void enregistrer(Employe employe) {
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
    }
}
