package com.Amendis.GestionParc.DAO;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.InstallationLogiciel;

public interface InstallationLogicielDAOMethods {

	public void add(InstallationLogiciel d);
	
	public void edite(InstallationLogiciel d);
	
	public boolean delete(int idInstallation);
	
	public List<InstallationLogiciel> findAll();
	
	public InstallationLogiciel findById(int idInstallation);
}
