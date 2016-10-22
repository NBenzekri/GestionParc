package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.InstallationLogiciel;
import com.Amendis.GestionParc.Hibernate.utils.GetDateTime;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class InstallationLogicielDAOImpl implements InstallationLogicielDAOMethods {
	Session session = HibernateUtil.openSession();

	@Override
	public void add(InstallationLogiciel d) {
		if(d.getDateInst()==null){
			d.setDateInst(GetDateTime.now());
		}
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(InstallationLogiciel d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idDir) {
		// TODO Auto-generated method stub

		InstallationLogiciel d = findById(idDir);
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
	public List<InstallationLogiciel> findAll() {

		return session.createQuery("select o from InstallationLogiciel o").list();
	}

	@Override
	public InstallationLogiciel findById(int idDir) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(InstallationLogiciel.class, idDir);
	}

}
