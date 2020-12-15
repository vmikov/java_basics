package hw_15.dao;

import hw_15.model.Client;
import hw_15.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class ClientDaoImpl implements ClientDao {
    Logger logger = Logger.getLogger(ClientDaoImpl.class);

    @Override
    public Client getById (int id) {
        logger.debug("ClientDaoImpl.getById(int id) method invoked with parameters: id = " + id);

        Client client;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            client = session.byId(Client.class).getReference(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return client;
    }

    @Override
    public Client getByPhone (long phone) {
        logger.debug("ClientDaoImpl.getByPhone(long phone) method invoked with parameters: phone = " + phone);

        Client client;
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Query query = session.createQuery("FROM Client c WHERE c.phone = :phone");
            query.setParameter("phone", phone);
            client = (Client)query.getSingleResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return client;
    }

    @Override
    public void save (Client client) {
        logger.debug("ClientDaoImpl.save(Client client) method invoked with parameters: client = " + client);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update (Client client) {
        logger.debug("ClientDaoImpl.update(Client client) method invoked with parameters: client = " + client);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete (Client client) {
        logger.debug("ClientDaoImpl.delete(Client client) method invoked with parameters: client = " + client);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            client.setId(0);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
