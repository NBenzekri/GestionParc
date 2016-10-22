package com.Amendis.GestionParc.DAO;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Direction;

public interface DirectionDAOMethods {

	public void add(Direction d);
	
	public void edite(Direction d);
	
	public boolean delete(int idDir);
	
	public List<Direction> findAll();
	
	public Direction findById(int idDir);
	
}
