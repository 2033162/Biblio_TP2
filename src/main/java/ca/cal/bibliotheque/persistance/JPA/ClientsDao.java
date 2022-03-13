package ca.cal.bibliotheque.persistance.JPA;

import ca.cal.bibliotheque.model.Clients;

public interface ClientsDao {
    <T> void save(T t);
    long createClients(Clients clients);
    Clients getClient(long clientId);
}
