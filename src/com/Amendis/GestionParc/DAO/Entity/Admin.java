package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
	private String loginAdmin;
	private String passwordAdmin;
	private String emailAdmin;

	public Admin(int idAdmin, String loginAdmin, String passwordAdmin, String emailAdmin) {
		this.idAdmin = idAdmin;
		this.loginAdmin = loginAdmin;
		this.passwordAdmin = passwordAdmin;
		this.emailAdmin = emailAdmin;
	}

	public Admin(String loginAdmin, String passwordAdmin, String emailAdmin) {
		this.loginAdmin = loginAdmin;
		this.passwordAdmin = passwordAdmin;
		this.emailAdmin = emailAdmin;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getLoginAdmin() {
		return loginAdmin;
	}

	public void setLoginAdmin(String loginAdmin) {
		this.loginAdmin = loginAdmin;
	}

	public String getPasswordAdmin() {
		return passwordAdmin;
	}

	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

}
