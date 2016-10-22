package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.DirectionDAOImpl;
import com.Amendis.GestionParc.DAO.DirectionDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Direction;

public class DirectionServiceImpl implements DirectionServiceMethods {

	DirectionDAOMethods dao =new DirectionDAOImpl();
	@Override
	public void add(Direction d) {
		dao.add(d);		
	}

	@Override
	public void edite(Direction d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idDir) {
		return dao.delete(idDir);
	}

	@Override
	public List<Direction> findAll() {
		return dao.findAll();
	}

	@Override
	public Direction findById(int idDir) {
		return dao.findById(idDir);
	}

}
