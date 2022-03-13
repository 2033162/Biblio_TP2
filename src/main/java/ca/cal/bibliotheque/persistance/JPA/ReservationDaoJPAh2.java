package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ReservationDaoJPAh2 implements ReservationDao {
    private EntityManagerFactory emf;

    public ReservationDaoJPAh2(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public <T> void save(T t) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long createReservation(Reservation reservation) {
        save(reservation);
        return reservation.getId();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(reservation);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeReservation(Reservation reservation) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        reservation = em.merge(reservation);
        em.remove(reservation);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Reservation getReservation(long reservationId) {
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        final Reservation reservation = em.find(Reservation.class, reservationId);
        em.getTransaction().commit();
        em.close();
        return reservation;
    }
}
