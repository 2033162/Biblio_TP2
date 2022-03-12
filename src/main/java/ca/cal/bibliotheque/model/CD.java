package ca.cal.bibliotheque.model;

public class CD extends Documents {
    private final long id;
    private String genreMusique;
    private String compositeur;
    private String interprete;

    public CD(Documents documents, String genreMusique, String compositeur, String interprete) {
        super(documents);
        this.id = documents.getId();
        this.genreMusique = genreMusique;
        this.compositeur = compositeur;
        this.interprete = interprete;
    }

    public long getId() {
        return id;
    }

    public String getGenreMusique() {
        return genreMusique;
    }

    public String getCompositeur() {
        return compositeur;
    }

    public String getInterprete() {
        return interprete;
    }

    public void setGenreMusique(String genreMusique) {
        this.genreMusique = genreMusique;
    }

    public void setCompositeur(String compositeur) {
        this.compositeur = compositeur;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    @Override
    public String toString() {
        return "CD{" +
                getDocument().toStringDocument() + '\n' +
                "genreMusique='" + genreMusique + '\'' +
                ", compositeur='" + compositeur + '\'' +
                ", interprete='" + interprete + '\'' +
                '}';
    }
}
