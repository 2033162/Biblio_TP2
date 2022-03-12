package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Reservation;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;

public class JDBCReservationH2 implements JDBCReservation {
    public void enregistrer(Reservation reservation) {
        JDBCBibliotheque.enregistrer("INSERT INTO RESERVATION VALUES (" +
                reservation.getId() +
                ",'" + reservation.getDateReservationChaine() +
                "'," + reservation.getClient().getId() +
                "," + reservation.getDocument().getId() + ");");
    }

    public Reservation getReservation(long reservationId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from RESERVATION WHERE id = ?");) {

            ps.setLong(1, reservationId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new Reservation(rs.getLong("id"),
                        rs.getDate("dateReservation"),
                        new JDBCClientH2().getClients(rs.getInt("idClient")),
                        new JDBCDocumentsH2().getDocuments(rs.getInt("idDocument")));
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(Reservation reservation) {
        JDBCBibliotheque.modification("UPDATE RESERVATION SET " +
                "dateReservation='" + reservation.getDateReservationChaine() +
                "', idClient=" + reservation.getClient().getId() +
                ", idDocument=" + reservation.getDocument().getId() +
                " WHERE id=" + reservation.getId() + ";");
    }

    public void suppression(Reservation reservation) {
        JDBCBibliotheque.suppression("RESERVATION", reservation.getId());
    }
}