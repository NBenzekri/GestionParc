package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fournisseur")
public class Fournisseur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFourn;
	private String nomFourn;
	private String emailFourn;
	private String addrFourn;
	private String telFourn;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(int idFourn, String nomFourn, String emailFourn, String addrFourn, String telFourn) {
		this.idFourn = idFourn;
		this.nomFourn = nomFourn;
		this.emailFourn = emailFourn;
		this.addrFourn = addrFourn;
		this.telFourn = telFourn;
	}

	public Fournisseur(String nomFourn, String emailFourn, String addrFourn, String telFourn) {
		this.nomFourn = nomFourn;
		this.emailFourn = emailFourn;
		this.addrFourn = addrFourn;
		this.telFourn = telFourn;
	}

	public int getIdFourn() {
		return idFourn;
	}

	public void setIdFourn(int idFourn) {
		this.idFourn = idFourn;
	}

	public String getNomFourn() {
		return nomFourn;
	}

	public void setNomFourn(String nomFourn) {
		this.nomFourn = nomFourn;
	}

	public String getEmailFourn() {
		return emailFourn;
	}

	public void setEmailFourn(String emailFourn) {
		this.emailFourn = emailFourn;
	}

	public String getAddrFourn() {
		return addrFourn;
	}

	public void setAddrFourn(String addrFourn) {
		this.addrFourn = addrFourn;
	}

	public String getTelFourn() {
		return telFourn;
	}

	public void setTelFourn(String telFourn) {
		this.telFourn = telFourn;
	}

}
