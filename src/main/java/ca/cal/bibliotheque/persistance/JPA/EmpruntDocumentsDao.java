package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.EmpruntDocuments;
import ca.cal.bibliotheque.model.Reservation;

public interface EmpruntDocumentsDao {
    <T> void save(T t);
    long createEmpruntDocuments(EmpruntDocuments empruntDocuments);
    void updateEmpruntDocuments(EmpruntDocuments empruntDocuments);
    void removeEmpruntDocuments(EmpruntDocuments empruntDocuments);
    EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId);
}
