package hw_14.services;

import hw_14.model.Client;

import java.math.BigInteger;

public interface ClientService {
    Client getById(int id);
    Client getByPhone(BigInteger phone);
    void save(Client client);
    void update(Client client);
    void delete(Client client);
}
