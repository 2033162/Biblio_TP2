package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.persistance.JPA.ClientsDao;

public class ServiceClient {

    private ClientsDao dao;

    public ServiceClient(ClientsDao dao) {
        this.dao = dao;
    }

    public long createClient(Clients client) {
        return dao.createClients(client);
    }

    public void updateClient(Clients clients) {
        dao.updateClients(clients);
    }

    public void removeClient(Clients clients) {
        dao.removeClients(clients);
    }

    public Clients getClient(long clientId) {
        return dao.getClient(clientId);
    }
}