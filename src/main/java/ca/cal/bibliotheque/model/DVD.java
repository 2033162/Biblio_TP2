package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DVD")
@Data
@NoArgsConstructor
public class DVD extends Documents {
    private long id;
    private int duree;
    private String genreFilm;

    public DVD(Documents documents, int duree, String genreFilm) {
        super(documents);
        this.id = documents.getId();
        this.duree = duree;
        this.genreFilm = genreFilm;
    }

    public DVD(Documents documents, DVD dvd) {
        super(documents);
        this.id = documents.getId();
        this.duree = dvd.getDuree();
        this.genreFilm = dvd.getGenreFilm();
    }

    @Override
    public long getId() {
        return id;
    }

    public int getDuree() {
        return duree;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    @Override
    public String toString() {
        return "DVD{" +
                getDocument().toStringDocument() + '\n' +
                "duree=" + duree +
                ", genreFilm='" + genreFilm + '\'' +
                '}';
    }
}
