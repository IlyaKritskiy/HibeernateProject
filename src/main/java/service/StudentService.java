package service;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentService {

    public void addStudent(Student student){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(student);
        transaction.commit();
        session.close();
    }

    public void removeStudent(int id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.remove(student);
        transaction.commit();
        session.close();
    }

}
