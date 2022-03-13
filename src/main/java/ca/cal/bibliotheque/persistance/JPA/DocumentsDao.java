package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

public interface DocumentsDao {
    <T> void save(T t);
    <T> void merge(T t);
    long createDocument(Documents documents);
    long createCD(CD CD);
    long createDVD(Documents documents, DVD DVD);
    long createLivre(Documents documents, Livre livres);
    Clients getClient(long clientId);
    Documents getDocument(long documentId);
    Clients getClientAvecDocuments(long clientId);
}
