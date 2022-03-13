package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Reservation;
import ca.cal.bibliotheque.persistance.JPA.ReservationDao;

public class ServiceReservation {

    private ReservationDao dao;

    public ServiceReservation(ReservationDao dao) {
        this.dao = dao;
    }

    public long createReservation(Reservation reservation) {
        return dao.createReservation(reservation);
    }

    public void updateReservation(Reservation reservation) {
        dao.updateReservation(reservation);
    }

    public void removeReservation(Reservation reservation) {
        dao.removeReservation(reservation);
    }

    public Reservation getReservation(long reservationID) {
        return dao.getReservation(reservationID);
    }
}
