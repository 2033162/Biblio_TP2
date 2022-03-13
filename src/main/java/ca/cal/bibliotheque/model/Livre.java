package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Livre")
@Data
@NoArgsConstructor
public class Livre extends Documents {
    private long id;

    private int nbrPages;
    private GenreLivre genreLivre;

    public Livre(Documents documents, int nbrPages, GenreLivre genreLivre) {
        super(documents);
        this.id = documents.getId();
        this.nbrPages = nbrPages;
        this.genreLivre = genreLivre;
    }

    public Livre(Documents documents, Livre livres) {
        super(documents);
        this.id = documents.getId();
        this.nbrPages = livres.getNbrPages();
        this.genreLivre = livres.getGenreLivre();
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
