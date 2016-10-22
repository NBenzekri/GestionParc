package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.AffectationMateriel;

public interface AffectationMaterielServiceMethods {
	public void add(AffectationMateriel d);

	public void edite(AffectationMateriel d);

	public boolean delete(int idAff);

	public List<AffectationMateriel> findAll();

	public AffectationMateriel findById(int idAff);
}
