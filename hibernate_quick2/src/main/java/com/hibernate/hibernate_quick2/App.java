package com.hibernate.hibernate_quick2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student stud  = new Student();
        stud.setId(4);
        stud.setName("Mukesh");
        stud.setAge(25);
        
        Configuration config = new Configuration();
        config.configure();
        
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stud);
        System.out.println("Object is saved");
        tx.commit();
        
        session.close();
        sf.close();
    }
}
