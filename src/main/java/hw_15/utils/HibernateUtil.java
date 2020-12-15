package hw_15.utils;

import hw_15.model.Account;
import hw_15.model.Client;
import hw_15.model.IdentityCode;
import hw_15.model.Status;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static Logger logger = Logger.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try  {
                Configuration cfg = new Configuration().configure();
                cfg.addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Account.class)
                        .addAnnotatedClass(Status.class)
                        .addAnnotatedClass(IdentityCode.class);
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
                sessionFactory = cfg.buildSessionFactory(registryBuilder.build());
            } catch (HibernateException e) {
                logger.error(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
