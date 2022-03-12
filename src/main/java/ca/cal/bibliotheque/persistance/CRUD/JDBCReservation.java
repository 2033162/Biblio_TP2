package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Reservation;

public interface JDBCReservation {
    void enregistrer(Reservation reservation);
    Reservation getReservation(long reservationId);
    void modification(Reservation reservation);
    void suppression(Reservation reservation);
}
