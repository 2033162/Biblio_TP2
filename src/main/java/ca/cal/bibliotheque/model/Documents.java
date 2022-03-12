package ca.cal.bibliotheque.model;

public class Documents {
    private final long id;
    public static final String C_LIVRE = "livre";
    public static final String C_CD = "CD";
    public static final String C_DVD = "DVD";

    private final String genreDocument;
    private EtatDocument etatDocument;
    private String titre;
    private String auteur;
    private String editeur;
    private int anneePublication;

    public Documents(long id, EtatDocument etatDocument, String genreDocument, String titre, String auteur, String editeur, int anneePublication) {
        this.id = id;
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
