package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Admin;

public interface AdminServiceMethods {
	public void add(Admin d);

	public void edite(Admin d);

	public boolean delete(int idAdmin);

	public List<Admin> findAll();

	public Admin findById(int idAdmin);
	
	public Admin valider(String loginAdmin ,String passwordAdmin);
}
