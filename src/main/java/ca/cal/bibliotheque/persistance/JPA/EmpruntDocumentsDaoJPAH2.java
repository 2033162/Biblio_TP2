package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.EmpruntDocuments;
import ca.cal.bibliotheque.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    public EmpruntDocuments getEmpruntDocuments(long empruntDocumentsId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final EmpruntDocuments empruntDocuments = em.find(EmpruntDocuments.class, empruntDocumentsId);
        em.getTransaction().commit();
        em.close();
        return empruntDocuments;
    }
}
