package service;

import entity.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class AddressService {

    public void addAddress(Address address){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(address);
        transaction.commit();
        session.close();
    }

    public void changeAddress(Address address){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(address);
        transaction.commit();
        session.close();
    }

    public void removeAddress(int id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        Address removeAddress = session.get(Address.class, id);
        session.remove(removeAddress);
        transaction.commit();
        session.close();
    }
}
