package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.AffectationMaterielDAOImpl;
import com.Amendis.GestionParc.DAO.AffectationMaterielDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.AffectationMateriel;

public class AffectationMaterielServiceImpl implements AffectationMaterielServiceMethods {

	AffectationMaterielDAOMethods dao =new AffectationMaterielDAOImpl();
	@Override
	public void add(AffectationMateriel d) {
		dao.add(d);		
	}

	@Override
	public void edite(AffectationMateriel d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idAff) {
		return dao.delete(idAff);
	}

	@Override
	public List<AffectationMateriel> findAll() {
		return dao.findAll();
	}

	@Override
	public AffectationMateriel findById(int idAff) {
		return dao.findById(idAff);
	}
}
