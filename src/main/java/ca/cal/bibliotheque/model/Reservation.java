package ca.cal.bibliotheque.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Clients client;
    private Documents document;

    public Reservation(long id, Date dateReservation, Clients client, Documents document) {
        this.id = id;
        this.dateReservation = dateReservation;
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
