package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.DVD;
import ca.cal.bibliotheque.model.Employe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeDaoJPAH2 implements EmployeDao {
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
    public long createEmploye(Employe employe) {
        save(employe);
        return employe.getId();
    }

    @Override
    public Employe getEmploye(long employeId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Employe employe = em.find(Employe.class, employeId);
        em.getTransaction().commit();
        em.close();
        return employe;
    }
}
