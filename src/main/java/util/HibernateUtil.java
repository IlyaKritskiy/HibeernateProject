package util;

import entity.Address;
import entity.Course;
import entity.Student;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Address.class)
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }
}
