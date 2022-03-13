package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

public interface DocumentsDao {
    <T> void save(T t);
    <T> void merge(T t);
    long createCD(CD cd);
    long createDVD(DVD dvd);
    long createLivre(Livre livre);
    Clients getClient(long clientId);
    Documents getDocument(long documentId);
    CD getCD(long cdID);
    DVD getDVD(long dvdID);
    Livre getLivre(long livreId);
    Clients getClientAvecDocuments(long clientId);
}
