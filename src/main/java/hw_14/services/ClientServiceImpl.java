package hw_14.services;

import hw_14.dao.ClientDao;
import hw_14.dao.ClientDaoImpl;
import hw_14.model.Client;

import java.math.BigInteger;

public class ClientServiceImpl implements ClientService {
    @Override
    public Client getById(int id) {
        ClientDao dao = new ClientDaoImpl();

        return dao.getById(id);
    }

    @Override
    public Client getByPhone(BigInteger phone) {
        ClientDao dao = new ClientDaoImpl();

        return dao.getByPhone(phone);
    }

    @Override
    public void save(Client client) {
        if(client == null) {
            System.out.println("Client is null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();
        dao.save(client);
    }

    @Override
    public void update(Client client) {
        if(client == null) {
            System.out.println("Client is null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();
        dao.update(client);
    }

    @Override
    public void delete(Client client) {
        if(client == null) {
            System.out.println("Client is null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();
        dao.delete(client);
    }
}
