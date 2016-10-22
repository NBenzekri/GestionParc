package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.User;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class UserDAOImpl implements UserDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(User d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(User d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}
	
	@Override
	public boolean delete(int idUser) {
		// TODO Auto-generated method stub
		
		User d = findById(idUser);
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
	public List<User> findAll() {
		
		return session.createQuery("select o from User o").list();
	} 

	@Override
	public User findById(int idUser) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(User.class, idUser);
	}

}
