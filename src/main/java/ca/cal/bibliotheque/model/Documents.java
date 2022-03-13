package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DOCUMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DOCUMENT_TYPE",discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
public abstract class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public static final String C_LIVRE = "livre";
    public static final String C_CD = "CD";
    public static final String C_DVD = "DVD";

    private String genreDocument;
    private EtatDocument etatDocument;
    private String titre;
    private String auteur;
    private String editeur;
    private int anneePublication;

    @OneToMany(mappedBy = "document")
    List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "document")
    List<EmpruntDocuments> empruntDocuments = new ArrayList<>();

    public Documents(EtatDocument etatDocument, String genreDocument, String titre, String auteur, String editeur, int anneePublication) {
        this.genreDocument = genreDocument;
        this.etatDocument = etatDocument;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.anneePublication = anneePublication;
    }

    public Documents(Documents documents) {
        this.id = documents.getId();
        this.genreDocument = documents.getGenreDocument();
        this.etatDocument = documents.getEtatDocument();
        this.titre = documents.getTitre();
        this.auteur = documents.getAuteur();
        this.editeur = documents.getEditeur();
        this.anneePublication = documents.getAnneePublication();
    }

    public Documents getDocument() {
        return this;
    }

    public long getId() {
        return id;
    }

    public String getGenreDocument() {
        return genreDocument;
    }

    public EtatDocument getEtatDocument() {
        return etatDocument;
    }

    public void setEtatDocument(EtatDocument etatDocument) {
        this.etatDocument = etatDocument;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String toStringDocument() {
        return "Documents{" +
                "genreDocument=" + genreDocument +
                ", etatDocument='" + etatDocument + '\'' +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", anneePublication=" + anneePublication +
                '}';
    }
}
