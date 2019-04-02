package util;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration cfgHibernate = new Configuration().configure();
            /*cfgHibernate.addAnnotatedClass(Manager.class);
            cfgHibernate.addAnnotatedClass(Customer.class);
            cfgHibernate.addAnnotatedClass(Order.class);
            cfgHibernate.addAnnotatedClass(Payment.class);*/
            cfgHibernate.addAnnotatedClass(Currency.class);

            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfgHibernate.getProperties());
            sessionFactory = cfgHibernate.buildSessionFactory(builder.build());

        } catch (Throwable e) {
            System.err.println("Err SessionFactory failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}