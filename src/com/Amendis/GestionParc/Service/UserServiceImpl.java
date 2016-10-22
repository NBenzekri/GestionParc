package com.Amendis.GestionParc.Service;

import java.util.List;

import com.Amendis.GestionParc.DAO.UserDAOImpl;
import com.Amendis.GestionParc.DAO.UserDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.User;

public class UserServiceImpl implements UserServiceMethods {
	UserDAOMethods dao =new UserDAOImpl();
	@Override
	public void add(User d) {
		dao.add(d);		
	}

	@Override
	public void edite(User d) {
		dao.edite(d);		
	}

	@Override
	public boolean delete(int idUser) {
		return dao.delete(idUser);
	}

	@Override
	public List<User> findAll() {
		return dao.findAll();
	}

	@Override
	public User findById(int idUser) {
		return dao.findById(idUser);
	}

}
