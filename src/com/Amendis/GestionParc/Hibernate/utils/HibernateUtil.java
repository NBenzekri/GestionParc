
package com.Amendis.GestionParc.Hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sessionFactory;

	static {
		try {
			// Création de la SessionFactory à partir de hibernate.cfg.xml
			sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}



	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static void close(){
		if(sessionFactory != null){
			sessionFactory.close();
		}
		sessionFactory=null;
	}
	
}