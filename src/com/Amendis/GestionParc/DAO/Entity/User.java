package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	private String loginUser;
	private String passwordUser;
	private String nomUser;
	private String prenomUser;
	private Date dateAjoutUser;
	private String droitsUser;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idUser, String loginUser, String passwordUser, String nomUser, String prenomUser,
			Date dateAjoutUser, String droitsUser) {
		this.idUser = idUser;
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.dateAjoutUser = dateAjoutUser;
		this.droitsUser = droitsUser;
	}

	public User(String loginUser, String passwordUser, String nomUser, String prenomUser, Date dateAjoutUser,
			String droitsUser) {
		this.loginUser = loginUser;
		this.passwordUser = passwordUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.dateAjoutUser = dateAjoutUser;
		this.droitsUser = droitsUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public Date getDateAjoutUser() {
		return dateAjoutUser;
	}

	public void setDateAjoutUser(Date dateAjoutUser) {
		this.dateAjoutUser = dateAjoutUser;
	}

	public String getDroitsUser() {
		return droitsUser;
	}

	public void setDroitsUser(String droitsUser) {
		this.droitsUser = droitsUser;
	}

}
