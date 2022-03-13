package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.EmpruntDocuments;

public interface EmpruntDocumentsDao {
    <T> void save(T t);
    long createEmpruntDocuments(EmpruntDocuments empruntDocuments);
    EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId);
}
