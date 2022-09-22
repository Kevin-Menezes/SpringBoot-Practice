package com.hb.FirstHibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entities.Song;

public class CreateApp 
{
    public static void main( String[] args )
    {
    	// This is a long cut way of getting session
    	// Create configuration to build session factory
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);
    	
    	// Create session factory to configure session
    	SessionFactory sessionFactory = configuration.buildSessionFactory(); // In the whole project we should have only 1 SessionFactory instance
    	
        Session session = sessionFactory.openSession(); // Initialize Hibernate session
        
        Song s = new Song();
        s.setSname("Chattan");
        s.setSinger("Bridge Music");
        
        session.beginTransaction();
        session.save(s); // save() is the inbuilt function -> to insert into db
        session.getTransaction().commit();
        
        System.out.println("-----------------Song inserted!-------------------");
        
        
    }
}
