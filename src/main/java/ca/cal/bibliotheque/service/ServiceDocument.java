package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EtatDocument;
import ca.cal.bibliotheque.persistance.CRUD.JDBCDocumentsH2;

import java.util.List;

public class ServiceDocument {
    public List<Documents> rechercheDocument(String genreDocument, EtatDocument etatDocument, String titre, String auteur, String editeur, int anneePublication) {
        return new JDBCDocumentsH2().rechercheDocument(genreDocument, etatDocument, titre, auteur, editeur, anneePublication);
    }
}
