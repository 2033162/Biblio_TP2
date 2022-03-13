package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EmpruntDocuments;

import java.util.List;

public interface EmpruntDocumentsDao {
    <T> void save(T t);
    long createEmpruntDocuments(EmpruntDocuments empruntDocuments);
    void updateEmpruntDocuments(EmpruntDocuments empruntDocuments);
    void removeEmpruntDocuments(EmpruntDocuments empruntDocuments);
    EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId);
    List<EmpruntDocuments> getClientEmprunt(long clientId);
    List<EmpruntDocuments> getClientEmpruntRetard(long clientId);
    String faireEmprunt(Clients clients, Documents documents);
    List<Object[]> getNbrEmpruntParMois();
}
