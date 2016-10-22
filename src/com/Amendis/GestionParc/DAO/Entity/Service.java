package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServ;	
	private String nomServ;
	private String chefServ;
	private int dirServ;

	
	@ManyToOne
	@JoinColumn(name="dirServ", referencedColumnName="idDir", insertable=false, updatable=false)
	private Direction dir;
		
	public Direction getDir() {
		return dir;
	}
	public void setDir(Direction dir) {
		this.dir = dir;
	}
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Service(int idServ, String nomServ, String chefServ, int dirServ) {
		this.idServ = idServ;
		this.nomServ = nomServ;
		this.chefServ = chefServ;
		this.dirServ = dirServ;
	}
	
	public Service(String nomServ, String chefServ, int dirServ) {
		this.nomServ = nomServ;
		this.chefServ = chefServ;
		this.dirServ = dirServ;
	}
	public int getIdServ() {
		return idServ;
	}
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	public String getNomServ() {
		return nomServ;
	}
	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}
	public String getChefServ() {
		return chefServ;
	}
	public void setChefServ(String chefServ) {
		this.chefServ = chefServ;
	}
	public int getDirServ() {
		return dirServ;
	}
	public void setDirServ(int dirServ) {
		this.dirServ = dirServ;
	}
	
	
	

}
