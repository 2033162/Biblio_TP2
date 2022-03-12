package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class EmpruntDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date dateInitial;
    private Date dateExpire;
    private int nbrRappel;

    @ManyToOne
    @JoinColumn(name = "client")
    @ToString.Exclude
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "document")
    @ToString.Exclude
    private Documents document;

    public EmpruntDocuments(long id, Date dateInitial, Date dateExpire, int nbrRappel, Clients client, Documents document) {
        this.id = id;
        this.dateInitial = dateInitial;
        this.dateExpire = dateExpire;
        this.nbrRappel = nbrRappel;
        this.client = client;
        this.document = document;
    }

    public long getId() {
        return id;
    }

    public Clients getClient() {
        return client;
    }

    public Documents getDocument() {
        return document;
    }

    public Date getDateInitial() {
        return dateInitial;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public String getDateInitialChaine() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateInitial);
    }

    public String getDateExpireChaine() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateExpire);
    }

    public int getNbrRappel() {
        return nbrRappel;
    }

    public void setDateInitial(Date dateInitial) {
        this.dateInitial = dateInitial;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }

    public void setNbrRappel(int nbrRappel) {
        this.nbrRappel = nbrRappel;
    }

    @Override
    public String toString() {
        return "EmpruntDocuments{" +
                "id=" + id +
                ", dateInitial=" + dateInitial +
                ", dateExpire=" + dateExpire +
                ", nbrRappel=" + nbrRappel +
                ", client=" + client +
                ", document=" + document.toStringDocument() +
                '}';
    }
}
