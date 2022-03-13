package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Employe;
import ca.cal.bibliotheque.model.Reservation;
import ca.cal.bibliotheque.persistance.CRUD.JDBCReservationH2;
import ca.cal.bibliotheque.persistance.JPA.EmployeDao;
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

    /*public void faireReservation(Reservation reservation) {
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
    }*/
}
