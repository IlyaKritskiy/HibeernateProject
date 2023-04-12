package service;

import entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CourseService {

    public void addCourse(Course course){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(course);
        transaction.commit();
        session.close();
    }

    public void updateCourse(Course course){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(course);
        transaction.commit();
        session.close();
    }

    public void removeCourse(int id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.remove(course);
        transaction.commit();
        session.close();
    }
}
