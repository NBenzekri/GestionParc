package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Service;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class ServiceDAOImpl implements ServiceDAOMethods {
	static Session session = HibernateUtil.openSession();

	@Override
	public void add(Service s) {
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();	
		System.out.println("success add!");		
	}

	@Override
	public void edite(Service s) {
		session.beginTransaction();
		session.merge(s);
		session.getTransaction().commit();	
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idServ) {
		Service s = this.findById(idServ);
		if (s!= null) {
			session.beginTransaction();
			session.delete(s);
			session.getTransaction().commit();			
			System.out.println("success delete!");
			return true;
		} else {	
			System.out.println("failure delete!");
			return false;
		}
		
	}

	@Override
	public List<Service> findAll() {
		return session.createQuery("select o from Service o").list();
	}

	@Override
	public Service findById(int idServ) {		
		return session.get(Service.class, idServ);
	}

}
