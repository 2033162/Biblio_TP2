package ca.cal.bibliotheque.model;

public class Livre extends Documents {
    private final long id;
    private int nbrPages;
    private GenreLivre genreLivre;

    public Livre(Documents documents, int nbrPages, GenreLivre genreLivre) {
        super(documents);
        this.id = documents.getId();
        this.nbrPages = nbrPages;
        this.genreLivre = genreLivre;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getNbrPages() {
        return nbrPages;
    }

    public GenreLivre getGenreLivre() {
        return genreLivre;
    }

    public void setNbrPages(int nbrPages) {
        this.nbrPages = nbrPages;
    }

    public void setGenreLivre(GenreLivre genreLivre) {
        this.genreLivre = genreLivre;
    }

    @Override
    public String toString() {
        return "Livre{" +
                getDocument().toStringDocument() + '\n' +
                "nbrPages=" + nbrPages +
                ", genreLivre='" + genreLivre + '\'' +
                '}';
    }
}
