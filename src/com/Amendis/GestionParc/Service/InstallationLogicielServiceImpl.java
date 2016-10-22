package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.InstallationLogicielDAOImpl;
import com.Amendis.GestionParc.DAO.InstallationLogicielDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.InstallationLogiciel;

public class InstallationLogicielServiceImpl implements InstallationLogicielServiceMethods {
	InstallationLogicielDAOMethods dao =new InstallationLogicielDAOImpl();
	@Override
	public void add(InstallationLogiciel d) {
		dao.add(d);		
	}

	@Override
	public void edite(InstallationLogiciel d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idInstallation) {
		return dao.delete(idInstallation);
	}

	@Override
	public List<InstallationLogiciel> findAll() {
		return dao.findAll();
	}

	@Override
	public InstallationLogiciel findById(int idInstallation) {
		return dao.findById(idInstallation);
	}

}
