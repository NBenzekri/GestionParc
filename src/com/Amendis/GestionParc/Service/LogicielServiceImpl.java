package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.LogicielDAOImpl;
import com.Amendis.GestionParc.DAO.LogicielDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Logiciel;

public class LogicielServiceImpl implements LogicielServiceMethods {
	LogicielDAOMethods dao =new LogicielDAOImpl();
	@Override
	public void add(Logiciel d) {
		dao.add(d);		
	}

	@Override
	public void edite(Logiciel d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idL) {
		return dao.delete(idL);
	}

	@Override
	public List<Logiciel> findAll() {
		return dao.findAll();
	}

	@Override
	public Logiciel findById(int idL) {
		return dao.findById(idL);
	}

}
