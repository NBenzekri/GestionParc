package com.Amendis.GestionParc.Vue;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.Amendis.GestionParc.Service.AdminServiceImpl;
import com.Amendis.GestionParc.Service.AdminServiceMethods;

@ManagedBean(name="adminSession")
@RequestScoped
public class AdminBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
	private String loginAdmin;
	private String passwordAdmin;
	private String emailAdmin;

	AdminServiceMethods AdminServ = new AdminServiceImpl();
	
	public void validateLogin(){

		if(AdminServ.valider(loginAdmin, passwordAdmin) !=null){
			System.out.println("success login");
		}else{
			System.out.println("Incorrect data");
		}
		
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
