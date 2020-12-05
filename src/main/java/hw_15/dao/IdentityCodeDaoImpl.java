package hw_15.dao;

import hw_15.model.IdentityCode;
import hw_15.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class IdentityCodeDaoImpl implements IdentityCodeDao {
    @Override
    public IdentityCode getById (int id) {
        IdentityCode identityCode;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            identityCode = session.byId(IdentityCode.class).getReference(id);
        }

        return identityCode;
    }

    @Override
    public void save(IdentityCode identityCode) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(identityCode);
            transaction.commit();
        }
    }

    @Override
    public void update (IdentityCode identityCode) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(identityCode);
            transaction.commit();
        }
    }

    @Override
    public void delete (IdentityCode identityCode) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(identityCode);
            transaction.commit();
            identityCode.setId(0);
        }
    }
}
