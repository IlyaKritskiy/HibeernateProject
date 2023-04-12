package service;

import entity.Course;
import entity.Student;
import entity.StudentCourse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentCourseService {

    public void addStudentToCourse(StudentCourse studentCourse){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(studentCourse);
        transaction.commit();
        session.close();
    }

    public void updateStudentOrCourse(StudentCourse studentCourse){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(studentCourse);
        transaction.commit();
        session.close();
    }

    public void removeStudentFromCourse(int id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        StudentCourse studentCourse = session.get(StudentCourse.class, id);
        session.remove(studentCourse);
        transaction.commit();
        session.close();
    }
}
