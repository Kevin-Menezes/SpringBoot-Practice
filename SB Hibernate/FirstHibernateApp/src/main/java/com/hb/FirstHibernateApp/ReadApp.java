package com.hb.FirstHibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entities.Song;
import com.hb.utils.HIbernateUtils;

public class ReadApp {

	public static void main(String[] args) {
    	
		// This is a better way of getting session
		Session session = HIbernateUtils.getSessionFactory().openSession(); // Initialize Hibernate session

        Song song = session.get(Song.class, 2); // get(); gets Song details from its id
        System.out.println(song);
	}

}
