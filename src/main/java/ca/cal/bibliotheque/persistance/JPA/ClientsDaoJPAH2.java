package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientsDaoJPAH2 implements ClientsDao {
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
    public long createClients(Clients clients) {
        save(clients);
        return clients.getId();
    }

    @Override
    public void updateClients(Clients clients) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(clients);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeClients(Clients clients) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        clients = em.merge(clients);
        em.remove(clients);

        em.getTransaction().commit();
        em.close();
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
}
