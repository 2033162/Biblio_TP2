package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CD extends Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String genreMusique;
    private String compositeur;
    private String interprete;

    @OneToMany(mappedBy = "cd")
    List<Documents> documents = new ArrayList<>();

    public CD(Documents documents, String genreMusique, String compositeur, String interprete) {
        super(documents);
        this.id = documents.getId();
        this.genreMusique = genreMusique;
        this.compositeur = compositeur;
        this.interprete = interprete;
    }

    public CD(Documents documents, CD cd) {
        super(documents);
        this.id = documents.getId();
        this.genreMusique = cd.getGenreMusique();
        this.compositeur = cd.getCompositeur();
        this.interprete = cd.getInterprete();
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
