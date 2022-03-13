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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date dateReservation;

    @ManyToOne
    @JoinColumn(name = "client")
    @ToString.Exclude
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "document")
    @ToString.Exclude
    private Documents document;

    public Reservation(Date dateReservation, Clients client, Documents document) {
        this.dateReservation = dateReservation;
        this.client = client;
        this.document = document;
    }

    public Clients getClient() {
        return client;
    }

    public Documents getDocument() {
        return document;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public String getDateReservationChaine() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateReservation);
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateReservation=" + dateReservation +
                ", client=" + client +
                ", document=" + document.toStringDocument() +
                '}';
    }
}
