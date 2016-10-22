package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Agent;

public interface AgentServiceMethods {
	public void add(Agent d);
	
	public void edite(Agent d);
	
	public boolean delete(int idAgent);
	
	public List<Agent> findAll();
	
	public Agent findById(int idAgent);
}
