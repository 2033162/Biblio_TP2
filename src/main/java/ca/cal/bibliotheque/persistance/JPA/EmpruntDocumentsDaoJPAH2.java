package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EmpruntDocuments;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmpruntDocumentsDaoJPAH2 implements EmpruntDocumentsDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");

    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        save(empruntDocuments);
        return empruntDocuments.getId();
    }

    @Override
    public void updateEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(empruntDocuments);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeEmpruntDocuments(EmpruntDocuments empruntDocuments) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        empruntDocuments = em.merge(empruntDocuments);
        em.remove(empruntDocuments);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final EmpruntDocuments empruntDocuments = em.find(EmpruntDocuments.class, empruntDocumentsId);
        em.getTransaction().commit();
        em.close();
        return empruntDocuments;
    }

    public List<EmpruntDocuments> getClientEmprunt(long clientId) {
        final EntityManager em = emf.createEntityManager();
        String sqlQuery = "SELECT e from EmpruntDocuments e WHERE e.client.id=:clientId";

        final TypedQuery<EmpruntDocuments> query = em.createQuery(sqlQuery, EmpruntDocuments.class);
        query.setParameter("clientId", clientId);
        List<EmpruntDocuments> listeEmpruntDoc = query.getResultList();

        em.close();
        return listeEmpruntDoc;
    }

    public List<EmpruntDocuments> getClientEmpruntRetard(long clientId) {

        String sqlQuery = "SELECT e from EmpruntDocuments e WHERE e.client.id=:clientId AND e.dateExpire < CURRENT_DATE()";
        final EntityManager em = emf.createEntityManager();

        final TypedQuery<EmpruntDocuments> query = em.createQuery(sqlQuery, EmpruntDocuments.class);
        query.setParameter("clientId", clientId);
        List<EmpruntDocuments> listeEmpruntDoc = query.getResultList();

        em.close();
        return listeEmpruntDoc;
    }

    public String faireEmprunt(Clients clients, Documents documents) {
        final EntityManager em = emf.createEntityManager();
        String message = "";

        double amende = 0.25;
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        List<EmpruntDocuments> empruntDocuments = getClientEmpruntRetard(clients.getId());
        if (empruntDocuments.size() > 0) {
            double totalFrais = 0;
            for(int i = 0; i < empruntDocuments.size(); i++) {
                EmpruntDocuments empruntDocument = empruntDocuments.get(i);
                empruntDocument.getDateExpire();
                long diffInMillies = Math.abs(today.getTime().getTime() - empruntDocument.getDateExpire().getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                totalFrais = totalFrais + (amende * diff);
            };
            message = "\nEmprunt interdit pour cause des amendes " + totalFrais + "$ \n";
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

            var empruntDocument = new EmpruntDocuments(
                    today.getTime(),
                    dateExpire.getTime(),
                    2,
                    clients,
                    documents);
            createEmpruntDocuments(empruntDocument);
        }
        em.close();
        return message;
    }

    public List<Object[]> getNbrEmpruntParMois() {
        String sqlQuery = "SELECT MONTH(dateInitial) AS mois, COUNT(*) AS nbr_emprunt from EmpruntDocuments e GROUP BY MONTH(dateInitial) ORDER BY MONTH(dateInitial)";
        final EntityManager em = emf.createEntityManager();

        List<Object[]> empruntParMois = em.createQuery(sqlQuery).getResultList();

        em.close();
        return empruntParMois;
    }
}
