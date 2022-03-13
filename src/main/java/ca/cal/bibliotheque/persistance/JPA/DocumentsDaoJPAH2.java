package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    public long createCD(CD cd) {
        save(cd);
        return cd.getId();
    }

    @Override
    public long createDVD(DVD dvd) {
        save(dvd);
        return dvd.getId();
    }

    @Override
    public long createLivre(Livre livre) {
        save(livre);
        return livre.getId();
    }

    public CD getCD(long cdID) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final CD cd = em.find(CD.class, cdID);
        em.getTransaction().commit();
        em.close();
        return cd;
    }

    @Override
    public DVD getDVD(long dvdID) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final DVD dvd = em.find(DVD.class, dvdID);
        em.getTransaction().commit();
        em.close();
        return dvd;
    }

    @Override
    public Livre getLivre(long livreId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Livre livre = em.find(Livre.class, livreId);
        em.getTransaction().commit();
        em.close();
        return livre;
    }
}
