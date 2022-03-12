package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.CD;

public interface JDBCCD {
    void enregistrer(CD cd);
    CD getCD(long cdId);
    void modification(CD cd);
    void suppression(CD cd);
}
