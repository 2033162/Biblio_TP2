package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Reservation;

public interface ReservationDao {
    <T> void save(T t);
    long createReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void removeReservation(Reservation reservation);
    Reservation getReservation(long reservationId);
}
