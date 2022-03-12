package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.persistance.CRUD.JDBCClientH2;

public class ServiceClient {
    public void enregistrer(Clients clients) {
        new JDBCClientH2().enregistrer(clients);
    }

    public void modification(Clients clients) {
        new JDBCClientH2().modification(clients);
    }

    public void suppression(Clients clients) {
        new JDBCClientH2().suppression(clients);
    }

    public Clients getClient(long clientId) {
        return new JDBCClientH2().getClients(clientId);
    }
}