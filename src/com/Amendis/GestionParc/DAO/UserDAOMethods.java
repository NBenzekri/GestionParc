package com.Amendis.GestionParc.DAO;

import java.util.List;

import com.Amendis.GestionParc.DAO.Entity.User;

public interface UserDAOMethods {

	public void add(User d);
	
	public void edite(User d);
	
	public boolean delete(int idUser);
	
	public List<User> findAll();
	
	public User findById(int idUser);
}
