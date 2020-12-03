package hw_14.utils;

import hw_14.model.Account;
import hw_14.model.Client;
import hw_14.model.Status;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try  {
                Configuration cfg = new Configuration().configure();
                cfg.addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Account.class)
                        .addAnnotatedClass(Status.class);
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
                sessionFactory = cfg.buildSessionFactory(registryBuilder.build());
            } catch (HibernateException e) {
                e.getMessage();
            }
        }
        return sessionFactory;
    }
}
