package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EtatDocument;

import java.util.List;

public interface JDBCDocuments {
    void enregistrer(Documents documents);
    Documents getDocuments(long documentsId);
    void modification(Documents documents);
    void suppression(Documents documents);
    List<Documents> rechercheDocument(String genreDocument, EtatDocument etatDocument, String titre, String auteur, String editeur, int anneePublication);
}