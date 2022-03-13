package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CD")
@Data
@NoArgsConstructor
public class CD extends Documents {
    private String genreMusique;
    private String compositeur;
    private String interprete;

    public CD(EtatDocument etatDocument, String genreDocument, String titre, String auteur, String editeur, int anneePublication, String genreMusique, String compositeur, String interprete) {
        this.setEtatDocument(etatDocument);
        this.setGenreDocument(genreDocument);
        this.setTitre(titre);
        this.setAuteur(auteur);
        this.setEditeur(editeur);
        this.setAnneePublication(anneePublication);
        this.genreMusique = genreMusique;
        this.compositeur = compositeur;
        this.interprete = interprete;
    }

    public CD(CD cd) {
        this.genreMusique = cd.getGenreMusique();
        this.compositeur = cd.getCompositeur();
        this.interprete = cd.getInterprete();
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
