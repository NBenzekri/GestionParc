package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Admin;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class AdminDAOImpl implements AdminDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Admin d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Admin d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}

	@Override
	public boolean delete(int idAdmin) {
		// TODO Auto-generated method stub

		Admin d = findById(idAdmin);
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
	public List<Admin> findAll() {

		return session.createQuery("select o from Admin o").list();
	}

	@Override
	public Admin findById(int idAdmin) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Admin.class, idAdmin);
	}

	@Override
	public Admin valider(String loginAdmin, String passwordAdmin) {
		Admin d = null;
		boolean exist =false;
		String sql = "SELECT * FROM Admin WHERE loginAdmin = '"+loginAdmin+"' AND passwordAdmin = '"+passwordAdmin+"' " ;
		Query selectAdmin = session.createSQLQuery(sql).addEntity(Admin.class);
		List<Admin> results = (List<Admin>)selectAdmin.list();
		if (results.size() > 0) {
			System.out.println("query executed!");
			d = results.get(0);
			exist = true;
			System.out.println("Correct Admin data!");
		}else{			
			System.out.println("incorrect data!");
		}
		return d;
		
//		String sql = "SELECT o FROM Admin o WHERE o.loginAdmin = :login AND o.passwordAdmin= :pass ";
		//String sql = "SELECT * FROM Admin WHERE loginAdmin = '"+loginAdmin+"' AND passwordAdmin = '"+passwordAdmin+"' " ;
//		List<Admin> results = session.createSQLQuery(sql).addEntity(Admin.class).setParameter("loginAdmin", loginAdmin)
//				.list();
	}

}
