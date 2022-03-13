package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

public interface DocumentsDao {
    <T> void save(T t);
    <T> void update(T t);
    <T> void remove(T t);
    long createCD(CD cd);
    long createDVD(DVD dvd);
    long createLivre(Livre livre);
    void updateCD(CD cd);
    void updateDVD(DVD dvd);
    void updateLivre(Livre livre);
    void removeCD(CD cd);
    void removeDVD(DVD dvd);
    void removeLivre(Livre livre);
    CD getCD(long cdID);
    DVD getDVD(long dvdID);
    Livre getLivre(long livreId);
}
