package com.hb.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entities.Song;

public class HIbernateUtils {
	
	private static SessionFactory sessionFactory = null;
	
	// This returns the session factory object
		public static SessionFactory getSessionFactory() {
			
			try {
				
				// This is to make sure that in the project only 1 instance of session factory is created
				if(sessionFactory==null) {
					
					// Create configuration to build session factory
			    	Configuration configuration = new Configuration();
			    	configuration.configure("hibernate.cfg.xml");
			    	configuration.addAnnotatedClass(Song.class);
			    	
			    	// Create session factory to configure session
			    	SessionFactory sessionFactory = configuration.buildSessionFactory(); // In the whole project we should have only 1 SessionFactory instance
				
				}
			}
			catch (Exception e) {
				System.out.println("Error in HibernateUtils.java - "+e);
			}
			
			return sessionFactory;
		}

}
