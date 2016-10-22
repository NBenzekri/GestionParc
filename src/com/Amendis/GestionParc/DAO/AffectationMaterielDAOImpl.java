package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.AffectationMateriel;
import com.Amendis.GestionParc.Hibernate.utils.GetDateTime;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class AffectationMaterielDAOImpl implements AffectationMaterielDAOMethods {
	Session session = HibernateUtil.openSession();

	@Override
	public void add(AffectationMateriel d) {
		if(d.getDateAff()==null){
			d.setDateAff(GetDateTime.now());
		}
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(AffectationMateriel d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idAff) {
		// TODO Auto-generated method stub

		AffectationMateriel d = findById(idAff);
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
	public List<AffectationMateriel> findAll() {

		return session.createQuery("select o from AffectationMateriel o").list();
	}

	@Override
	public AffectationMateriel findById(int idAff) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(AffectationMateriel.class, idAff);
	}

}
