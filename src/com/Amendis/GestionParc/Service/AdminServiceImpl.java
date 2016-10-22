package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.AdminDAOImpl;
import com.Amendis.GestionParc.DAO.AdminDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Admin;

public class AdminServiceImpl implements AdminServiceMethods {
	AdminDAOMethods dao =new AdminDAOImpl();
	@Override
	public void add(Admin d) {
		dao.add(d);		
	}

	@Override
	public void edite(Admin d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idAdmin) {
		return dao.delete(idAdmin);
	}

	@Override
	public List<Admin> findAll() {
		return dao.findAll();
	}

	@Override
	public Admin findById(int idAdmin) {
		return dao.findById(idAdmin);
	}

	@Override
	public Admin valider(String loginAdmin, String passwordAdmin) {
		return dao.valider(loginAdmin, passwordAdmin);
	}
}
