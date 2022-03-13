package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

public interface DocumentsDao {
    <T> void save(T t);
    <T> void update(T t);
    long createCD(CD cd);
    long createDVD(DVD dvd);
    long createLivre(Livre livre);
    void updateCD(CD cd);
    void updateDVD(DVD dvd);
    void updateLivre(Livre livre);
    CD getCD(long cdID);
    DVD getDVD(long dvdID);
    Livre getLivre(long livreId);
}
