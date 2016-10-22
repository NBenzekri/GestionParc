package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.InstallationLogiciel;

public interface InstallationLogicielServiceMethods {
	public void add(InstallationLogiciel d);
	
	public void edite(InstallationLogiciel d);
	
	public boolean delete(int idInstallation);
	
	public List<InstallationLogiciel> findAll();
	
	public InstallationLogiciel findById(int idInstallation);
}
