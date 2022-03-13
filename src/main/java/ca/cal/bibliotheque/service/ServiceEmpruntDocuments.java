package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EmpruntDocuments;
import ca.cal.bibliotheque.persistance.JPA.EmpruntDocumentsDao;

import java.util.List;

public class ServiceEmpruntDocuments {

    private EmpruntDocumentsDao dao;

    public ServiceEmpruntDocuments(EmpruntDocumentsDao dao) {
        this.dao = dao;
    }

    public long createEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        return dao.createEmpruntDocuments(empruntDocuments);
    }

    public void updateEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        dao.updateEmpruntDocuments(empruntDocuments);
    }

    public void removeEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        dao.removeEmpruntDocuments(empruntDocuments);
    }

    public EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId) {
        return dao.getEmpruntDocuments(empruntDocumentsId);
    }

    public List<EmpruntDocuments> getClientEmprunt(long clientId) {
        return dao.getClientEmprunt(clientId);
    }

    public String faireEmprunt(Clients clients, Documents documents) {
        return dao.faireEmprunt(clients, documents);
    }

    public Long[] getNbrEmpruntParMois() {

        List<Object[]> empruntParMois = dao.getNbrEmpruntParMois();

        Long[] nbrEmpruntParMois = new Long[] {0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L};
        for(int i = 0; i < empruntParMois.size(); i++) {
            Object[] empruntMois = empruntParMois.get(i);
            nbrEmpruntParMois[(int)empruntMois[0] - 1] = (Long)empruntMois[1];
        }

        return nbrEmpruntParMois;
    }
}
