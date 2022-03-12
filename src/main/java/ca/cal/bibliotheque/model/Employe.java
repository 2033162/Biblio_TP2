package ca.cal.bibliotheque.model;

public class Employe {
    private final long id;
    private String nom;
    private String prenom;
    private Fonction fonction;

    public Employe(long id, String nom, String prenom, Fonction fonction) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", fonction=" + fonction +
                '}';
    }
}
