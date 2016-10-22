package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Fournisseur;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class FournisseurDAOImpl implements FournisseurDAOMethods {
	Session session = HibernateUtil.openSession();

	@Override
	public void add(Fournisseur d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Fournisseur d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idFourn) {
		// TODO Auto-generated method stub

		Fournisseur d = findById(idFourn);
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
	public List<Fournisseur> findAll() {

		return session.createQuery("select o from Fournisseur o").list();
	}

	@Override
	public Fournisseur findById(int idFourn) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Fournisseur.class, idFourn);
	}

}
