package com.Amendis.GestionParc.Vue;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String pwd;
	private String msg;
	private String user;
	private String res = "";
	private boolean login;
	
	private static String SUCCESS = "success";
	private static String ERROR = "error";
	
	private static String USERNAME = "admin";
	private static String PASSWORD = "admin";

	public void Alogin(ActionEvent e){

	
		if (USERNAME.equalsIgnoreCase(user) && PASSWORD.equalsIgnoreCase(pwd)) {
			setLogin(true);
			res =  SUCCESS;
		}

		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Erreur","You have entered an invalid username and/or password");
		facesContext.addMessage(null, facesMessage);

		res = ERROR;
	    
	}
	
	public String Alogout() {
		setLogin(false);
		return "login??faces-redirect=true";
	}
	
	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	


	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public void validateLogin() {
		if ("".equalsIgnoreCase(user) || "".equalsIgnoreCase(pwd)) {
			FacesContext.getCurrentInstance().addMessage("icon_prefix",
					new FacesMessage("Incorrect Username and Passowrd, Please enter correct data."));
			System.out.println("Incorrect Username and Passowrd, Please enter correct data.!");
		}else{
			
		}

	}
	// validate login

	/*
	 * public String validateUsernamePassword() { boolean valid =
	 * LoginDAO.validate(user, pwd); if (valid) { HttpSession session =
	 * SessionUtils.getSession(); session.setAttribute("username", user); return
	 * "admin"; } else { FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_WARN,
	 * "Incorrect Username and Passowrd",
	 * "Please enter correct username and Password")); return "login"; } }
	 * 
	 * //logout event, invalidate session public String logout() { HttpSession
	 * session = SessionUtils.getSession(); session.invalidate(); return
	 * "login"; }
	 */
}
