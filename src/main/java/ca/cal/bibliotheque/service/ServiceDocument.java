package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.*;
import ca.cal.bibliotheque.persistance.JPA.DocumentsDao;

import java.util.List;

public class ServiceDocument {
    private DocumentsDao dao;

    public ServiceDocument(DocumentsDao dao) {
        this.dao = dao;
    }

    public long createCD(CD cd) {
        return dao.createCD(cd);
    }

    public long createDVD(DVD dvd) {
        return dao.createDVD(dvd);
    }

    public long createLivre(Livre livre) {
        return dao.createLivre(livre);
    }

    public void updateCD(CD cd) {
        dao.updateCD(cd);
    }

    public void updateDVD(DVD dvd) {
        dao.updateDVD(dvd);
    }

    public void updateLivre(Livre livre) {
        dao.updateLivre(livre);
    }

    public void removeCD(CD cd) {
        dao.removeCD(cd);
    }

    public void removeDVD(DVD dvd) {
        dao.removeDVD(dvd);
    }

    public void removeLivre(Livre livre) {
        dao.removeLivre(livre);
    }

    public CD getCD(long cdID) {
        return dao.getCD(cdID);
    }

    public DVD getDVD(long dvdID) {
        return dao.getDVD(dvdID);
    }

    public Livre getLivre(long livreId) {
        return dao.getLivre(livreId);
    }

    public List<Documents> rechercheDocument(String genreDocument, EtatDocument etatDocument, String titre, String auteur, String editeur, int anneePublication) {
        return dao.rechercheDocument(genreDocument, etatDocument, titre, auteur, editeur, anneePublication);
    }
}
