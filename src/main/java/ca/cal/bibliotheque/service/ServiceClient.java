package ca.cal.bibliotheque.service;

import ca.cal.bibliotheque.model.Clients;
import ca.cal.bibliotheque.model.Employe;
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

    public Clients getClient(long clientId) {
        return dao.getClient(clientId);
    }

    /*public void enregistrer(Clients clients) {
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
    }*/
}