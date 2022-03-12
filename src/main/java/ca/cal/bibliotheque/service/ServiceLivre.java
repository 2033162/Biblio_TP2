package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Livre;
import ca.cal.bibliotheque.persistance.CRUD.JDBCLivreH2;

public class ServiceLivre {
    public void enregistrer(Livre livre) {
        new JDBCLivreH2().enregistrer(livre);
    }

    public void modification(Livre livre) {
        new JDBCLivreH2().modification(livre);
    }

    public void suppression(Livre livre) {
        new JDBCLivreH2().suppression(livre);
    }

    public Livre getLivre(long livreId) {
        return new JDBCLivreH2().getLivre(livreId);
    }
}
