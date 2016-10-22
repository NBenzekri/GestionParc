package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.AgentDAOImpl;
import com.Amendis.GestionParc.DAO.AgentDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Agent;

public class AgentServiceImpl implements AgentServiceMethods {

	AgentDAOMethods dao =new AgentDAOImpl();
	@Override
	public void add(Agent d) {
		dao.add(d);		
	}

	@Override
	public void edite(Agent d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idDir) {
		return dao.delete(idDir);
	}

	@Override
	public List<Agent> findAll() {
		return dao.findAll();
	}

	@Override
	public Agent findById(int idDir) {
		return dao.findById(idDir);
	}
}
