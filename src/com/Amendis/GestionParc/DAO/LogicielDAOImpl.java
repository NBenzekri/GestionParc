package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Logiciel;
import com.Amendis.GestionParc.Hibernate.utils.GetDateTime;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class LogicielDAOImpl implements LogicielDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Logiciel d) {
		if(d.getDateL()==null){
			d.setDateL(GetDateTime.now());
		}
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Logiciel d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}
	
	@Override
	public boolean delete(int idL) {
		// TODO Auto-generated method stub
		
		Logiciel d = findById(idL);
		if (d!=null) {
			session.beginTransaction();
			session.delete(d);
			session.getTransaction().commit();
			System.out.println("success delete!");
			return true;
		} else {
			System.out.println("failure delete!");
			return false;
		}
		
	}

	@Override
	public List<Logiciel> findAll() {
		
		return session.createQuery("select o from Logiciel o").list();
	} 

	@Override
	public Logiciel findById(int idL) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Logiciel.class, idL);
	}

}
