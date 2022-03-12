package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Livre;

public interface JDBCLivre {
    void enregistrer(Livre livre);
    Livre getLivre(long livreId);
    void modification(Livre livre);
    void suppression(Livre livre);
}
