package ca.cal.bibliotheque.persistance.CRUD;

import ca.cal.bibliotheque.model.Clients;

public interface JDBCBClient {
    void enregistrer(Clients clients);
    Clients getClients(long clientsId);
    void modification(Clients clients);
    void suppression(Clients clients);
}