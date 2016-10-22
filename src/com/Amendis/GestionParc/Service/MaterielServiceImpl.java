package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.MaterielDAOImpl;
import com.Amendis.GestionParc.DAO.MaterielDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Materiel;

public class MaterielServiceImpl implements MaterielServiceMethods {
	MaterielDAOMethods dao =new MaterielDAOImpl();
	@Override
	public void add(Materiel d) {
		dao.add(d);		
	}

	@Override
	public void edite(Materiel d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idMat) {
		return dao.delete(idMat);
	}

	@Override
	public List<Materiel> findAll() {
		return dao.findAll();
	}

	@Override
	public Materiel findById(int idMat) {
		return dao.findById(idMat);
	}

}
