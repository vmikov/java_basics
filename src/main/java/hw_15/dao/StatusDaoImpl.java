package hw_15.dao;

import hw_15.model.Status;
import hw_15.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StatusDaoImpl implements StatusDao {
    @Override
    public Status getById (int id) {
        Status entity;

        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()){
            entity = session.byId(Status.class).getReference(id);
        }

        return entity;
    }

    @Override
    public void save (Status entity) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public void update (Status entity) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete (Status entity) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            entity.setId(0);
        }
    }
}
