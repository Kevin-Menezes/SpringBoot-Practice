package com.hb.FirstHibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entities.Song;
import com.hb.utils.HIbernateUtils;

public class DeleteApp {

	public static void main(String[] args) {
		
		Session session = HIbernateUtils.getSessionFactory().openSession(); // Initialize Hibernate session
        
        Song song = session.get(Song.class, 2); // First we get song details by particular id... then we delete it
        
        session.beginTransaction();
        session.delete(song); // delete() is the inbuilt function -> to delete row from db
        session.getTransaction().commit();
	
	}
	
	

}
