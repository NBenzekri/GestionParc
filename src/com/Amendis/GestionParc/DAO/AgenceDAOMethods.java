package com.Amendis.GestionParc.DAO;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Agence;

public interface AgenceDAOMethods {

	
	public void add(Agence d);

	public void edite(Agence d);

	public boolean delete(int idAgence);

	public List<Agence> findAll();

	public Agence findById(int idAgence);
}
