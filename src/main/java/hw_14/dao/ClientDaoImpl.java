package hw_14.dao;

import hw_14.model.Client;
import hw_14.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigInteger;

public class ClientDaoImpl implements ClientDao {
    @Override
    public Client getById (int id) {
        Client client;

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            client = session.byId(Client.class).getReference(id);
        }

        return client;
    }

    @Override
    public Client getByPhone(BigInteger phone) {
        Client client;
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Query query = session.createQuery("FROM Client c WHERE c.phone = :phone");
            query.setParameter("phone", phone);
            client = (Client)query.getSingleResult();
        }

        return client;
    }

    @Override
    public void save(Client client) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }

    @Override
    public void update (Client client) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    @Override
    public void delete (Client client) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
            client.setId(0);
        }
    }
}
