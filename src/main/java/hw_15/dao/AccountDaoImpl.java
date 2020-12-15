package hw_15.dao;

import hw_15.model.Account;
import hw_15.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDaoImpl implements AccountDao {
    Logger logger = Logger.getLogger(AccountDaoImpl.class);

    @Override
    public Account getById (int id) {
        logger.debug("AccountDaoImpl.getById(int id) method invoked with parameters: id = " + id);

        Account account;
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            account = session.byId(Account.class).getReference(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }

        return account;
    }

    @Override
    public void save (Account account) {
        logger.debug("AccountDaoImpl.save(Account account) method invoked with parameters: account = " + account);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void update (Account account) {
        logger.debug("AccountDaoImpl.update(Account account) method invoked with parameters: account = " + account);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete (Account account) {
        logger.debug("AccountDaoImpl.delete(Account account) method invoked with parameters: account = " + account);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
            account.setId(0);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }
}
