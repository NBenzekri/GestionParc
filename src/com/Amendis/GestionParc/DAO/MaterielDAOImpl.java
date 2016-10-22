package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Materiel;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class MaterielDAOImpl implements MaterielDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Materiel d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Materiel d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idMat) {
		// TODO Auto-generated method stub

		Materiel d = findById(idMat);
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
	public List<Materiel> findAll() {

		return session.createQuery("select o from Materiel o").list();
	}

	@Override
	public Materiel findById(int idMat) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Materiel.class, idMat);
	}

}
