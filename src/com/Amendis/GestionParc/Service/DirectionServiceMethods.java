package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.Direction;

public interface DirectionServiceMethods {

public void add(Direction d);
	
	public void edite(Direction d);
	
	public boolean delete(int idDir);
	
	public List<Direction> findAll();
	
	public Direction findById(int idDir);
}
