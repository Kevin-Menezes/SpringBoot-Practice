package com.hb.FirstHibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entities.Song;
import com.hb.utils.HIbernateUtils;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session = HIbernateUtils.getSessionFactory().openSession(); // Initialize Hibernate session
		
        Song s = session.get(Song.class, 1); // First we get all details and then we update a particular detail
        s.setSinger("Justin B");
        
        session.beginTransaction();
        session.update(s); // update() is the inbuilt function -> to update into db
        session.getTransaction().commit();
	}
	

}
