package hw_15.dao;

import hw_15.model.Client;

public interface ClientDao {
    Client getById(int id);
    Client getByPhone(long phone);
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}
