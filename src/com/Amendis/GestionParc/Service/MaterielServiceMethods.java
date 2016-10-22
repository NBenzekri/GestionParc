package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Materiel;

public interface MaterielServiceMethods {
	public void add(Materiel d);
	
	public void edite(Materiel d);
	
	public boolean delete(int idMat);
	
	public List<Materiel> findAll();
	
	public Materiel findById(int idMat);
}
