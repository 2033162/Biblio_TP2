package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Employe;

public interface EmployeDao {
    <T> void save(T t);
    long createEmploye(Employe employe);
    void updateEmploye(Employe employe);
    void removeEmploye(Employe employe);
    Employe getEmploye(long employeId);
}
