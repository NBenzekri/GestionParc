package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Service;

public interface ServiceServiceMethods {

public void add(Service s);
	
	public void edite(Service s);
	
	public boolean delete(int idServ);
	
	public List<Service> findAll();
	
	public Service findById(int idServ);
}
