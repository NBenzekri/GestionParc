package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Agence;

public interface AgenceServiceMethods {
	public void add(Agence d);

	public void edite(Agence d);

	public boolean delete(int idAgence);

	public List<Agence> findAll();

	public Agence findById(int idAgence);
}
