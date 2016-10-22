package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="direction")
public class Direction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDir;
	
	private String nomDir;
	private String chefDir;
	
	public Direction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direction(int idDir, String nomDir, String chefDir) {
		this.idDir = idDir;
		this.nomDir = nomDir;
		this.chefDir = chefDir;
	}	
	
	public Direction(String nomDir, String chefDir) {
		this.nomDir = nomDir;
		this.chefDir = chefDir;
	}

	public int getIdDir() {
		return idDir;
	}

	public void setIdDir(int idDir) {
		this.idDir = idDir;
	}

	public String getNomDir() {
		return nomDir;
	}

	public void setNomDir(String nomDir) {
		this.nomDir = nomDir;
	}

	public String getChefDir() {
		return chefDir;
	}

	public void setChefDir(String chefDir) {
		this.chefDir = chefDir;
	}
	
	
	

}
