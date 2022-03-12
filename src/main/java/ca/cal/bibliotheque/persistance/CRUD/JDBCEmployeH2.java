package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Employe;
import ca.cal.bibliotheque.model.Fonction;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;

public class JDBCEmployeH2 implements JDBCEmploye {
    public void enregistrer(Employe employe) {
        JDBCBibliotheque.enregistrer("INSERT INTO EMPLOYE VALUES (" +
                employe.getId() +
                ",'" + employe.getNom() +
                "','" + employe.getPrenom() +
                "','" + employe.getFonction() + "');");
    }

    public Employe getEmploye(long employeId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from EMPLOYE WHERE id = ?");) {

            ps.setLong(1, employeId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new Employe(rs.getLong("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        Fonction.get(rs.getString("fonction")));
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(Employe employe) {
        JDBCBibliotheque.modification("UPDATE EMPLOYE SET " +
                "nom='" + employe.getNom() +
                "', prenom='" + employe.getPrenom() +
                "', fonction='" + employe.getFonction() + "'" +
                " WHERE id=" + employe.getId() + ";");
    }

    public void suppression(Employe employe) {
        JDBCBibliotheque.suppression("EMPLOYE", employe.getId());
    }
}
