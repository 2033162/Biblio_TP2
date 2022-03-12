package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.EmpruntDocuments;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmpruntDocumentsH2 implements JDBCEmpruntDocuments {
    public void enregistrer(EmpruntDocuments empruntDocuments) {
        JDBCBibliotheque.enregistrer("INSERT INTO EMPRUNTDOCUMENT VALUES (" +
                empruntDocuments.getId() +
                ",'" + empruntDocuments.getDateInitialChaine() +
                "','" + empruntDocuments.getDateExpireChaine() +
                "'," + empruntDocuments.getNbrRappel() +
                "," + empruntDocuments.getClient().getId() +
                "," + empruntDocuments.getDocument().getId() + ");");
    }

    public EmpruntDocuments getEmpruntDocument(long empruntDocumentId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from EMPRUNTDOCUMENT WHERE id = ?");) {

            ps.setLong(1, empruntDocumentId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new EmpruntDocuments(rs.getLong("id"),
                        rs.getDate("dateInitial"),
                        rs.getDate("dateExpire"),
                        rs.getInt("nbrRappel"),
                        new JDBCClientH2().getClients(rs.getInt("idClient")),
                        new JDBCDocumentsH2().getDocuments(rs.getInt("idDocument")));
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(EmpruntDocuments empruntDocuments) {
        JDBCBibliotheque.modification("UPDATE EMPRUNTDOCUMENT SET " +
                "dateInitial='" + empruntDocuments.getDateInitialChaine() +
                "', dateExpire='" + empruntDocuments.getDateExpireChaine() +
                "', nbrRappel=" + empruntDocuments.getNbrRappel() +
                ", idClient=" + empruntDocuments.getClient().getId() +
                ", idDocument=" + empruntDocuments.getDocument().getId() +
                " WHERE id=" + empruntDocuments.getId() + ";");
    }

    public void suppression(EmpruntDocuments empruntDocuments) {
        JDBCBibliotheque.suppression("EMPRUNTDOCUMENT", empruntDocuments.getId());
    }

    public long getMaxId() {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT max(id) as maxId from DOCUMENTS");) {

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return rs.getLong("maxId");
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return 0;
        }
    }

    public List<EmpruntDocuments> getClientEmpruntRetard(long clientId) {
        List<EmpruntDocuments> listeEmpruntDoc = new ArrayList<>();
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from EMPRUNTDOCUMENT WHERE idClient=? AND dateExpire < CURRENT_DATE()");) {

            ps.setLong(1, clientId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                do {
                    rs.next();
                    EmpruntDocuments empruntDocuments = new EmpruntDocuments(rs.getLong("id"),
                            rs.getDate("dateInitial"),
                            rs.getDate("dateExpire"),
                            rs.getInt("nbrRappel"),
                            new JDBCClientH2().getClients(rs.getInt("idClient")),
                            new JDBCDocumentsH2().getDocuments(rs.getInt("idDocument")));
                    listeEmpruntDoc.add(empruntDocuments);
                } while (!rs.last());
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
        return listeEmpruntDoc;
    }

    public int[] getNbrEmpruntParMois() {
        int[] nbrEmpruntParMois = new int[12];
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT MONTH(dateInitial) AS mois, COUNT(*) AS nbr_emprunt from EMPRUNTDOCUMENT GROUP BY MONTH(dateInitial) ORDER BY MONTH(dateInitial)");) {

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                do {
                    rs.next();
                    nbrEmpruntParMois[rs.getInt("mois") - 1] = rs.getInt("nbr_emprunt");
                } while (!rs.last());
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
        return nbrEmpruntParMois;
    }
}
