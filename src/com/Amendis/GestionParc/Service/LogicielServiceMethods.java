package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Logiciel;

public interface LogicielServiceMethods {

	public void add(Logiciel d);
	
	public void edite(Logiciel d);
	
	public boolean delete(int idL);
	
	public List<Logiciel> findAll();
	
	public Logiciel findById(int idL);
}
