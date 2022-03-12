package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Documents;
import ca.cal.bibliotheque.model.EtatDocument;
import ca.cal.bibliotheque.persistance.DB.JDBCConfig;
import ca.cal.bibliotheque.persistance.DB.JDBCException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDocumentsH2 implements JDBCDocuments {

    public void enregistrer(Documents documents) {
        JDBCBibliotheque.enregistrer("INSERT INTO DOCUMENTS VALUES (" +
                documents.getId() +
                ",'" + documents.getGenreDocument() +
                "','" + documents.getEtatDocument() +
                "','" + documents.getTitre() +
                "','" + documents.getAuteur() +
                "','" + documents.getEditeur() +
                "'," + documents.getAnneePublication() + ");");
    }

    public Documents getDocuments(long documentsId) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from DOCUMENTS WHERE id = ?");) {

            ps.setLong(1, documentsId);

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                rs.next();
                return new Documents(
                        rs.getLong("id"),
                        EtatDocument.get(rs.getString("etatDocument")),
                        rs.getString("genreDocument"),
                        rs.getString("titre"),
                        rs.getString("auteur"),
                        rs.getString("editeur"),
                        rs.getInt("anneePublication")
                );
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
    }

    public void modification(Documents documents) {
        JDBCBibliotheque.modification("UPDATE DOCUMENTS SET " +
                "etatDocument='" + documents.getEtatDocument() +
                "', genreDocument='" + documents.getGenreDocument() +
                "', titre='" + documents.getTitre() +
                "', auteur='" + documents.getAuteur() +
                "', editeur='" + documents.getEditeur() +
                "', anneePublication='" + documents.getAnneePublication() + "'" +
                " WHERE id=" + documents.getId() + ";");
    }

    public void suppression(Documents documents) {
        JDBCBibliotheque.suppression("DOCUMENTS", documents.getId());
    }

    public List<Documents> rechercheDocument(String genreDocument, EtatDocument etatDocument, String titre, String auteur, String editeur, int anneePublication) {
        List<Documents> listeDocuments = new ArrayList<>();
        String where = "";
        if (!genreDocument.trim().equals("")) {
            where += (where.equals("") ? "" : " AND ");
            where += " (genreDocument='" + genreDocument + "')";
        }

        if (!titre.trim().equals("")) {
            where += (where.equals("") ? "" : " AND ");
            where += " (titre='" + titre + "')";
        }

        if (!auteur.trim().equals("")) {
            where += (where.equals("") ? "" : " AND ");
            where += " (auteur='" + auteur + "')";
        }

        if (!editeur.trim().equals("")) {
            where += (where.equals("") ? "" : " AND ");
            where += " (editeur='" + editeur + "')";
        }

        if (anneePublication != 0) {
            where += (where.equals("") ? "" : " AND ");
            where += " (anneePublication=" + anneePublication + ")";
        }
        // Open a connection
        try(Connection conn = DriverManager.getConnection(JDBCConfig.getDbUrl(),JDBCConfig.getUSER(),JDBCConfig.getPASS());
            PreparedStatement ps = conn.prepareStatement("SELECT * from DOCUMENTS WHERE " + where);) {

            // NOTEZ le try à l'intérieur du try
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Documents documents = new Documents(
                            rs.getLong("id"),
                            EtatDocument.get(rs.getString("etatDocument")),
                            rs.getString("genreDocument"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getString("editeur"),
                            rs.getInt("anneePublication")
                    );
                    listeDocuments.add(documents);
                }
            }
        } catch (SQLException e) {
            JDBCException.handleException(e);
            return null;
        }
        return listeDocuments;
    }
}
