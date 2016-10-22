package login;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.Amendis.GestionParc.DAO.AdminDAOImpl;
import com.Amendis.GestionParc.DAO.AdminDAOMethods;
import com.Amendis.GestionParc.DAO.Entity.Admin;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String pwd;
	private String msg;
	private String user;
	private String email;
	private Admin admin ;
	AdminDAOMethods AdminDao = new AdminDAOImpl();

	// validate login
	public String validateUsernamePassword() {
		Admin validate = AdminDao.valider(user, pwd);
		FacesContext fc = FacesContext.getCurrentInstance();
		String viewId = fc.getViewRoot().getViewId();
		String uri = ((HttpServletRequest) fc.getExternalContext().getRequest()).getRequestURI();
		if (validate != null) {
			this.setAdmin(validate);
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			session.setAttribute("email", validate.getEmailAdmin());
			setUser(validate.getLoginAdmin());
			setEmail(validate.getEmailAdmin());
			this.setUser(user);
			fc.getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(),
					null,"/index.xhtml");
			System.out.println(fc.getExternalContext().getRequestContextPath()+"\n "+viewId+" \n"+uri);
			// FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
			// "Welcome"+valid.getLoginAdmin(),
			// "correct data:"+valid.getEmailAdmin()+" id: "
			// +valid.getIdAdmin());
			// FacesContext.getCurrentInstance().addMessage(null, msg);
			return "admin";
		} else {
			this.setAdmin(null);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd",
					"Please enter correct username and Password");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login";
		}
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		this.setAdmin(null);
		return "login";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}