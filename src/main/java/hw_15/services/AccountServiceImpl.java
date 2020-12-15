package hw_15.services;

import hw_15.dao.AccountDao;
import hw_15.dao.AccountDaoImpl;
import hw_15.model.Account;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

public class AccountServiceImpl implements AccountService {
    Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Override
    public Account getById(int id) {
        logger.debug("AccountServiceImpl.getById(int id) method invoked with parameters: id = " + id);

        AccountDao dao = new AccountDaoImpl();
        Account account = null;

        try {
            account = dao.getById(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return account;
    }

    @Override
    public void save(Account account) {
        logger.debug("AccountServiceImpl.save(Account account) method invoked with parameters: account = " + account);

        if(account == null) {
            logger.error("no account to save in the method AccountServiceImpl.save(Account account): account = null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();

        try {
            dao.save(account);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Account account) {
        logger.debug("AccountServiceImpl.update(Account account) method invoked with parameters: account = " + account);

        if(account == null) {
            logger.error("no account to update in the method AccountServiceImpl.update(Account account): account = null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();

        try {
            dao.update(account);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Account account) {
        logger.debug("AccountServiceImpl.delete(Account account) method invoked with parameters: account = " + account);

        if(account == null) {
            logger.error("no account to delete in the method AccountServiceImpl.delete(Account account): account = null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();

        try {
            dao.delete(account);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }
}
