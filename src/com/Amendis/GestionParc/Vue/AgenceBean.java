package com.Amendis.GestionParc.Vue;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.Amendis.GestionParc.DAO.Entity.Agence;
import com.Amendis.GestionParc.Service.AgenceServiceImpl;
import com.Amendis.GestionParc.Service.AgenceServiceMethods;


@ManagedBean
@ViewScoped
public class AgenceBean implements Serializable {

	private int idAgence;
	private String nomAgence;
	private String addrAgence;
	private Date date;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
	private boolean showform;
	private boolean showData;
	private static int count;
	private String login;

	// Service layer calling
	private AgenceServiceMethods Serv = new AgenceServiceImpl();
	// params list declaration
	private List<Agence> list;

	private String success;
	private String id;
	private String operation;

	@PostConstruct
	public void init() {
		list = Serv.findAll();
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;
	}

	public void showformAction(ActionEvent e) {
		nomAgence = "";
		addrAgence = "";
		date = new Date();
		showform = true;
	}

	public void hideformAction(ActionEvent e) {
		showform = false;
	}

	public void showDataAction(ActionEvent e) {
		if (count % 2 == 0) {
			nom = "Cacher";
			showData = true;
		} else {
			nom = "Afficher";
			showData = false;
		}

		count++;
		System.out.println(count);
	}

	public void ajouter(ActionEvent e) {

		Agence d = null;

		System.out.println("Test : " + operation + " " + id);

		if ("modifier".equalsIgnoreCase(operation)) {

			d = Serv.findById(Integer.valueOf(id));
			if ("".equalsIgnoreCase(nomAgence) || "".equalsIgnoreCase(addrAgence)) {
				if ("".equalsIgnoreCase(nomAgence)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur:", "Nom vide: Vous devez indiquer une Agence"));
				}
				if ("".equalsIgnoreCase(addrAgence)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Donner une adresse!"));

				}
			} else {
				if (date == null)
					d.setDate(new Date());
				else
					d.setDate(date);
				d.setNomAgence(nomAgence);
				d.setAddrAgence(addrAgence);

				Serv.edite(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Agence Modifié avec succée"));
				System.out.println("Agence success edite");
				setShowform(false);
			}
		} else {
			d = new Agence();
			if ("".equalsIgnoreCase(nomAgence) || "".equalsIgnoreCase(addrAgence)) {
				if ("".equalsIgnoreCase(nomAgence)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur:", "Nom vide : Vous devez indiquer une Agence"));
				}
				if ("".equalsIgnoreCase(addrAgence)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Donner une adresse!"));

				}
			} else {
				d.setNomAgence(nomAgence);
				d.setAddrAgence(addrAgence);
				d.setDate(new Date());

				Serv.add(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Agence ajouté"));

				System.out.println("agence success add");
				setShowform(false);
			}
		}

		nomAgence = "";
		addrAgence = "";

		success = "Agence ajouté";
		id = "";
		operation = "";
	}

	public void supprimer(ActionEvent e) {
		System.out.println("Agence supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		try {
		Serv.delete(new Integer(param.get("id")));
		list = Serv.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
				"Agence " + param.get("ns") + " a été supprimé"));
		} catch (Exception e2) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
					"On ne peut supprimer cette Direction, c'est un clé étrangère dans la table service"));
			System.err.println(e2);
		}
	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int id = Integer.valueOf(param.get("id"));
		Agence dir = Serv.findById(id);
		nomAgence = dir.getNomAgence();
		addrAgence = dir.getAddrAgence();
		date = dir.getDate();
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public String isLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isShowform() {
		return showform;
	}

	public void setShowform(boolean showform) {
		this.showform = showform;
	}

	public boolean isShowData() {
		return showData;
	}

	public void setShowData(boolean showData) {
		this.showData = showData;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		AgenceBean.count = count;
	}

	public List<Agence> getList() {
		return list;
	}

	public void setList(List<Agence> list) {
		this.list = list;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

}
