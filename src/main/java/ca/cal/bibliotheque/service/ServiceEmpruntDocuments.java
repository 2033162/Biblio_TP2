package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EmpruntDocuments;
import ca.cal.bibliotheque.persistance.CRUD.JDBCEmpruntDocumentsH2;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ServiceEmpruntDocuments {
    public void enregistrer(EmpruntDocuments empruntDocument) {
        new JDBCEmpruntDocumentsH2().enregistrer(empruntDocument);
    }

    public void faireEmprunt(Clients clients, Documents documents) {
        double amende = 0.25;
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        List<EmpruntDocuments> empruntDocuments = new JDBCEmpruntDocumentsH2().getClientEmpruntRetard(clients.getId());
        if (empruntDocuments.size() > 0) {
            double totalFrais = 0;
            for(int i = 0; i < empruntDocuments.size(); i++) {
                EmpruntDocuments empruntDocument = empruntDocuments.get(i);
                empruntDocument.getDateExpire();
                long diffInMillies = Math.abs(today.getTime().getTime() - empruntDocument.getDateExpire().getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                totalFrais = totalFrais + (amende * diff);
            };
            System.out.println("\nEmprunt interdit pour cause des amendes " + totalFrais + "$ \n");
        }
        else {
            double tarifEmprunt;
            int periodeEmprunt;
            if (clients.getVille().equalsIgnoreCase("JavaTown")) {
                //les résidents de Javatown, peuvent emprunter gratuitement
                tarifEmprunt = 0;
            } else {
                tarifEmprunt = 1;
            }
            if (documents.getGenreDocument().equalsIgnoreCase(Documents.C_LIVRE)) {
                periodeEmprunt = 3;
            } else if (documents.getGenreDocument().equalsIgnoreCase(Documents.C_CD)) {
                periodeEmprunt = 2;
            } else {
                //DVD
                periodeEmprunt = 1;
            }

            Calendar dateExpire = today;
            dateExpire.add(Calendar.WEEK_OF_YEAR, periodeEmprunt);

            long idEmpruntDocument = new JDBCEmpruntDocumentsH2().getMaxId() + 1;
            var empruntDocument = new EmpruntDocuments(idEmpruntDocument,
                    today.getTime(),
                    dateExpire.getTime(),
                    2,
                    clients,
                    documents);
            enregistrer(empruntDocument);
        }
    }

    public int[] getNbrEmpruntParMois() {
        return new JDBCEmpruntDocumentsH2().getNbrEmpruntParMois();
    }

    public void modification(EmpruntDocuments empruntDocument) {
        new JDBCEmpruntDocumentsH2().modification(empruntDocument);
    }

    public void suppression(EmpruntDocuments empruntDocument) {
        new JDBCEmpruntDocumentsH2().suppression(empruntDocument);
    }

    public EmpruntDocuments getEmpruntDocument(long empruntDocumentId) {
        return new JDBCEmpruntDocumentsH2().getEmpruntDocument(empruntDocumentId);
    }
}
