package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.FournisseurDAOImpl;
import com.Amendis.GestionParc.DAO.FournisseurDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Fournisseur;

public class FournisseurServiceImpl implements FournisseurServiceMethods {
	FournisseurDAOMethods dao =new FournisseurDAOImpl();
	@Override
	public void add(Fournisseur d) {
		dao.add(d);		
	}

	@Override
	public void edite(Fournisseur d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idFourn) {
		return dao.delete(idFourn);
	}

	@Override
	public List<Fournisseur> findAll() {
		return dao.findAll();
	}

	@Override
	public Fournisseur findById(int idFourn) {
		return dao.findById(idFourn);
	}
}
