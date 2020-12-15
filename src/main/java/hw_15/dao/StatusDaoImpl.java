package hw_15.dao;

import hw_15.model.Status;
import hw_15.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatusDaoImpl implements StatusDao {
    Logger logger = Logger.getLogger(StatusDaoImpl.class);

    @Override
    public Status getById (int id) {
        logger.debug("StatusDaoImpl.getById(int id) method invoked with parameters: id = " + id);

        Status entity;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()){
            entity = session.byId(Status.class).getReference(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return entity;
    }

    @Override
    public void save (Status entity) {
        logger.debug("StatusDaoImpl.save(Status entity) method invoked with parameters: entity = " + entity);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update (Status entity) {
        logger.debug("StatusDaoImpl.update(Status entity) method invoked with parameters: entity = " + entity);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete (Status entity) {
        logger.debug("StatusDaoImpl.delete(Status entity) method invoked with parameters: entity = " + entity);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            entity.setId(0);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
