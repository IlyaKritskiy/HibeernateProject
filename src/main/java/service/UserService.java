package service;

import entity.Role;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class UserService {

    public void addUser(User user){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(encode(user));
        transaction.commit();
        session.close();
    }

    public static User encode(User user){
        String codingPassword;
        char[] arraySymbols = user.getPassword().toCharArray();
        for (int i = 0; i < arraySymbols.length; i++) {
            arraySymbols[i] = (char) ((int)arraySymbols[i] + 3);
        }
        codingPassword = String.valueOf(arraySymbols);
        return new User(user.getEmail(), codingPassword, Role.valueOf(user.getRole()));
    }

    public static String decode(User user){
        String decodePassword;
        char[] arraySymbols = user.getPassword().toCharArray();
        for (int i = 0; i < arraySymbols.length; i++) {
            arraySymbols[i] = (char) ((int)arraySymbols[i] - 3);
        }
        decodePassword = String.valueOf(arraySymbols);
        return decodePassword;
    }

    public boolean checkUser(String emailCheck, String passwordCheck){
        Session session = HibernateUtil.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> list = query.list();
        for (User user: list) {
            if (emailCheck.equals(user.getEmail()) && passwordCheck.equals(user.getPassword())) {
                System.out.println("Welcome!");
                return true;
            }
        }
        return false;
    }

    public boolean checkUserEmail(String emailCheck){
        Session session = HibernateUtil.openSession();
        Query<User> query = session.createQuery("form User", User.class);
        List<User> list = query.list();
        for(User user: list){
            if(emailCheck.equals(user.getEmail())){
                return true;
            }
        }
        return false;
    }

    public void removeUser(int id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        transaction.commit();
        session.close();
    }

}
