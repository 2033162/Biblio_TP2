package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.*;
import ca.cal.bibliotheque.persistance.CRUD.JDBCDocumentsH2;
import ca.cal.bibliotheque.persistance.JPA.DocumentsDao;

import java.util.List;

public class ServiceDocument {
    private DocumentsDao dao;

    public ServiceDocument(DocumentsDao dao) {
        this.dao = dao;
    }

    public long createDocument(Documents documents) {
        return dao.createDocument(documents);
    }

    public long createCD(CD CD) {
        return dao.createCD(CD);
    }

    public long createDVD(Documents documents, DVD DVD) {
        return dao.createDVD(documents, DVD);
    }

    public long createLivre(Documents documents, Livre livres) {
        return dao.createLivre(documents, livres);
    }

    /*public List<Documents> rechercheDocument(String genreDocument, EtatDocument etatDocument, String titre, String auteur, String editeur, int anneePublication) {
        return new JDBCDocumentsH2().rechercheDocument(genreDocument, etatDocument, titre, auteur, editeur, anneePublication);
    }*/
}
