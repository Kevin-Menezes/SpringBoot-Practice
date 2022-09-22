package com.jpa.FirstJpaApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {
    	
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); // pu links this file and the .xml file
    	EntityManager em = emf.createEntityManager();
    	
        Song s = new Song(); // This is like get() of hibernate
        s.setSname("Venom");
        s.setSinger("Eminem");
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        System.out.println(s);
    }
}
