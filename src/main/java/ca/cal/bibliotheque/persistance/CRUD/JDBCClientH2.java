package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;

public class JDBCClientH2 implements JDBCBClient {

    public void enregistrer(Clients clients) {
        JDBCBibliotheque.enregistrer("INSERT INTO CLIENTS VALUES (" +
                        clients.getId() +
                        ",'" + clients.getNom() +
                        "','" + clients.getPrenom() +
                        "','" + clients.getRue() +
                        "','" + clients.getVille() +
                        "','" + clients.getCodePostal() +
                        "','" + clients.getNumeroTelephone() +
                        "','" + clients.getDateInscriptionChaine() +
                        "'," + clients.getNbrEmpruntEnCour() + ");");
    }

    public Clients getClients(long clientsId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from CLIENTS WHERE id = ?");) {

            ps.setLong(1, clientsId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new Clients(rs.getLong("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("rue"),
                        rs.getString("ville"),
                        rs.getString("codePostal"),
                        rs.getString("numeroTelephone"),
                        rs.getDate("dateInscription"),
                        rs.getInt("nbrEmpruntEnCour"));
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(Clients clients) {
        JDBCBibliotheque.modification("UPDATE CLIENTS SET " +
                "nom='" + clients.getNom() +
                "', prenom='" + clients.getPrenom() +
                "', rue='" + clients.getRue() +
                "', ville='" + clients.getVille() +
                "', codePostal='" + clients.getCodePostal() +
                "', numeroTelephone='" + clients.getNumeroTelephone() +
                "', dateInscription='" + clients.getDateInscriptionChaine() +
                "', nbrEmpruntEnCour=" + clients.getNbrEmpruntEnCour() +
                " WHERE id=" + clients.getId() + ";");
    }

    public void suppression(Clients clients) {
        JDBCBibliotheque.suppression("CLIENTS", clients.getId());
    }
}