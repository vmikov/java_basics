package hw_15.dao;

import hw_15.model.Account;
import hw_15.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account getById (int id) {
        Account account;

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            account = session.byId(Account.class).getReference(id);
        }

        return account;
    }

    @Override
    public void save (Account account) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        }
    }

    @Override
    public void update (Account account) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        }
    }

    @Override
    public void delete (Account account) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
            account.setId(0);
        }
    }
}
