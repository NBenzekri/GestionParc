package com.Amendis.GestionParc.DAO;

import java.util.List;

import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.Entity.Agent;
import com.Amendis.GestionParc.Hibernate.utils.HibernateUtil;

public class AgentDAOImpl implements AgentDAOMethods {

	Session session = HibernateUtil.openSession();

	@Override
	public void add(Agent d) {
		session.beginTransaction();
		session.save(d);
		session.getTransaction().commit();
		System.out.println("success add!");
	}

	@Override
	public void edite(Agent d) {
		session.beginTransaction();
		session.merge(d);
		session.getTransaction().commit();
		System.out.println("success edite!");
	}
	
	@Override
	public boolean delete(int idAgent) {
		// TODO Auto-generated method stub
		
		Agent d = findById(idAgent);
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
	public List<Agent> findAll() {
		
		return session.createQuery("select o from Agent o").list();
	} 

	@Override
	public Agent findById(int idAgent) {
		// TODO Auto-generated method stub
		System.out.println("success findById !");
		return session.get(Agent.class, idAgent);
	}

}
