package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Agence;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class AgenceDAOImpl implements AgenceDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Agence d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Agence d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idDir) {
		// TODO Auto-generated method stub

		Agence d = findById(idDir);
		if (d != null) {
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
	public List<Agence> findAll() {

		return session.createQuery("select o from Agence o").list();
	}

	@Override
	public Agence findById(int idDir) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Agence.class, idDir);
	}

}
