package hw_15.services;

import hw_15.model.Client;

public interface ClientService {
    Client getById(int id);
    Client getByPhone(long phone);
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}
