package hw_15.dao;

import hw_15.model.IdentityCode;
import hw_15.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class IdentityCodeDaoImpl implements IdentityCodeDao {
    Logger logger = Logger.getLogger(IdentityCodeDaoImpl.class);

    @Override
    public IdentityCode getById (int id) {
        logger.debug("IdentityCodeDaoImpl.getById(int id) method invoked with parameters: id = " + id);

        IdentityCode identityCode;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            identityCode = session.byId(IdentityCode.class).getReference(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return identityCode;
    }

    @Override
    public void save(IdentityCode identityCode) {
        logger.debug("IdentityCodeDaoImpl.save(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(identityCode);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update (IdentityCode identityCode) {
        logger.debug("IdentityCodeDaoImpl.update(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(identityCode);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete (IdentityCode identityCode) {
        logger.debug("IdentityCodeDaoImpl.delete(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(identityCode);
            transaction.commit();
            identityCode.setId(0);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
