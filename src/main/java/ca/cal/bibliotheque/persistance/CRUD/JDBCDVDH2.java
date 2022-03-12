package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.DVD;
import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;

public class JDBCDVDH2 implements JDBCDVD {
    public void enregistrer(DVD dvd) {
        new JDBCDocumentsH2().enregistrer(dvd.getDocument());
        JDBCBibliotheque.enregistrer("INSERT INTO DVD VALUES (" +
                dvd.getId() +
                "," + dvd.getDuree() +
                ",'" + dvd.getGenreFilm() +
                "'," + dvd.getDocument().getId() + ");");
    }

    public DVD getDVD(long dvdId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from DVD WHERE id = ?");) {

            ps.setLong(1, dvdId);

            Documents documents = new JDBCDocumentsH2().getDocuments(dvdId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new DVD(
                        documents,
                        rs.getInt("duree"),
                        rs.getString("genreFilm")
                );
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(DVD dvd) {
        new JDBCDocumentsH2().modification(dvd.getDocument());
        JDBCBibliotheque.modification("UPDATE DVD SET " +
                "duree='" + dvd.getDuree() +
                "', genreFilm='" + dvd.getGenreFilm() + "'" +
                " WHERE id=" + dvd.getId() + ";");
    }

    public void suppression(DVD dvd) {
        JDBCBibliotheque.suppression("DVD", dvd.getId());
        new JDBCDocumentsH2().suppression(dvd.getDocument());
    }
}
