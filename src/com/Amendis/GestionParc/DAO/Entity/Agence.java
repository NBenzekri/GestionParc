package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "agence")
public class Agence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAgence;
	private String nomAgence;
	private String addrAgence;
	@Column(name = "date", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private Date date;

	public Agence(String nomAgence, String addrAgence, Date date) {
		this.nomAgence = nomAgence;
		this.addrAgence = addrAgence;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agence(int idAgence, String nomAgence, String addrAgence) {
		this.idAgence = idAgence;
		this.nomAgence = nomAgence;
		this.addrAgence = addrAgence;
	}

	public Agence(String nomAgence, String addrAgence) {
		this.nomAgence = nomAgence;
		this.addrAgence = addrAgence;
	}

	public int getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(int idAgence) {
		this.idAgence = idAgence;
	}

	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getAddrAgence() {
		return addrAgence;
	}

	public void setAddrAgence(String addrAgence) {
		this.addrAgence = addrAgence;
	}

}
