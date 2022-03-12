package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DocumentsDaoJPAH2 implements DocumentsDao {
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
    public <T> void merge(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createDocument(Documents documents) {
        final Documents document = new Documents(documents);
        save(document);
        return document.getId();
    }

    @Override
    public long createCD(Documents documents, CD CD) {
        final CD cd = new CD(documents, CD);
        save(cd);
        return cd.getId();
    }

    @Override
    public long createDVD(Documents documents, DVD DVD) {
        final DVD dvd = new DVD(documents, DVD);
        save(dvd);
        return dvd.getId();
    }

    @Override
    public long createLivre(Documents documents, Livre livres) {
        final Livre livre = new Livre(documents, livres);
        save(livre);
        return livre.getId();
    }

    @Override
    public Clients getClient(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Clients client = em.find(Clients.class, clientId);

        em.getTransaction().commit();
        em.close();
        return client;
    }

    @Override
    public Documents getDocument(long documentId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Documents document = em.find(Documents.class, documentId);

        em.getTransaction().commit();
        em.close();
        return document;
    }

    @Override
    public Clients getClientAvecDocuments(long clientId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final TypedQuery<Clients> query = em.createQuery(
                "select client from Clients client left join fetch client.empruntDocuments clientEmpruntDocument where client.id = :clientId"
                        , Clients.class);
        query.setParameter("clientId", clientId);
        final Clients client = query.getSingleResult();

        em.getTransaction().commit();
        em.close();
        return client;
    }
}
