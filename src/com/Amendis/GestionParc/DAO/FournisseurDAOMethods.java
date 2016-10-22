package com.Amendis.GestionParc.DAO;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Fournisseur;

public interface FournisseurDAOMethods {

	public void add(Fournisseur d);
	
	public void edite(Fournisseur d);
	
	public boolean delete(int idFourn);
	
	public List<Fournisseur> findAll();
	
	public Fournisseur findById(int idFourn);
}
