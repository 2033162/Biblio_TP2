package ca.cal.bibliotheque.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clients {
    private final long id;
    private String nom;
    private String prenom;
    private String rue;
    private String ville;
    private String codePostal;
    private String numeroTelephone;
    private Date dateInscription;
    private int nbrEmpruntEnCour;

    public Clients(long id, String nom, String prenom, String rue, String ville, String codePostal, String numeroTelephone, Date dateInscription, int nbrEmpruntEnCour) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.numeroTelephone = numeroTelephone;
        this.dateInscription = dateInscription;
        this.nbrEmpruntEnCour = nbrEmpruntEnCour;
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

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public String getDateInscriptionChaine() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateInscription);
    }

    public int getNbrEmpruntEnCour() {
        return nbrEmpruntEnCour;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public void setNbrEmpruntEnCour(int nbrEmpruntEnCour) {
        this.nbrEmpruntEnCour = nbrEmpruntEnCour;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", dateInscription='" + dateInscription + '\'' +
                ", nbrEmpruntEnCour=" + nbrEmpruntEnCour +
                '}';
    }
}
