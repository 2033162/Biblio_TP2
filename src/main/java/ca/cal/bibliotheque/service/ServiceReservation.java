package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Reservation;
import ca.cal.bibliotheque.persistance.CRUD.JDBCReservationH2;

public class ServiceReservation {
    public void faireReservation(Reservation reservation) {
        new JDBCReservationH2().enregistrer(reservation);
    }

    public void modification(Reservation reservation) {
        new JDBCReservationH2().modification(reservation);
    }

    public void suppression(Reservation reservation) {
        new JDBCReservationH2().suppression(reservation);
    }

    public Reservation getReservation(long reservationId) {
        return new JDBCReservationH2().getReservation(reservationId);
    }
}
