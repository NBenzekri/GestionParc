package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.AgenceDAOImpl;
import com.Amendis.GestionParc.DAO.AgenceDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Agence;

public class AgenceServiceImpl implements AgenceServiceMethods {

	AgenceDAOMethods dao =new AgenceDAOImpl();
	@Override
	public void add(Agence d) {
		dao.add(d);		
	}

	@Override
	public void edite(Agence d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idAgence) {
		return dao.delete(idAgence);
	}

	@Override
	public List<Agence> findAll() {
		return dao.findAll();
	}

	@Override
	public Agence findById(int idAgence) {
		return dao.findById(idAgence);
	}
}
