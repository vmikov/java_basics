package hw_15.services;

import hw_15.dao.ClientDao;
import hw_15.dao.ClientDaoImpl;
import hw_15.model.Client;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

public class ClientServiceImpl implements ClientService {
    Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Override
    public Client getById(int id) {
        logger.debug("ClientServiceImpl.getById(int id) method invoked with parameters: id = " + id);

        ClientDao dao = new ClientDaoImpl();
        Client client = null;

        try {
            client = dao.getById(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return client;
    }

    @Override
    public Client getByPhone(long phone) {
        logger.debug("ClientServiceImpl.getByPhone(long phone) method invoked with parameters: phone = " + phone);

        ClientDao dao = new ClientDaoImpl();
        Client client = null;

        try {
            client = dao.getByPhone(phone);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return client;
    }

    @Override
    public void save(Client client) {
        logger.debug("ClientServiceImpl.save(Client client) method invoked with parameters: client = " + client);

        if(client == null) {
            logger.error("no client to save in the method ClientServiceImpl.save(Client client): client = null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();

        try {
            dao.save(client);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Client client) {
        logger.debug("ClientServiceImpl.update(Client client) method invoked with parameters: client = " + client);

        if(client == null) {
            logger.error("no client to update in the method ClientServiceImpl.update(Client client): client = null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();

        try {
            dao.update(client);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Client client) {
        logger.debug("ClientServiceImpl.delete(Client client) method invoked with parameters: client = " + client);

        if(client == null) {
            logger.error("no client to delete in the method ClientServiceImpl.delete(Client client): client = null");
            return;
        }

        ClientDao dao = new ClientDaoImpl();

        try {
            dao.delete(client);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }
}
