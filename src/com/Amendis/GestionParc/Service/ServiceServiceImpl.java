package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.ServiceDAOImpl;
import com.Amendis.GestionParc.DAO.ServiceDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Service;

public class ServiceServiceImpl implements ServiceServiceMethods {

	ServiceDAOMethods dao = new ServiceDAOImpl();
	@Override
	public void add(Service s) {
		dao.add(s);
	}

	@Override
	public void edite(Service s) {
		dao.edite(s);
	}

	@Override
	public boolean delete(int idServ) {
		return dao.delete(idServ);
	}

	@Override
	public List<Service> findAll() {
		return dao.findAll();
	}

	@Override
	public Service findById(int idServ) {
		return dao.findById(idServ);
	}

}
