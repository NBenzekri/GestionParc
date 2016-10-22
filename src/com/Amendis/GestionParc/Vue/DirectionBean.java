package com.Amendis.GestionParc.Vue;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


import com.Amendis.GestionParc.DAO.Entity.*;
import com.Amendis.GestionParc.Service.DirectionServiceImpl;
import com.Amendis.GestionParc.Service.DirectionServiceMethods;

@ManagedBean
@ViewScoped
public class DirectionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idDir;
	private String nomDir;
	private String chefDir;

	private String nom;
	private boolean showform;
	private boolean showData;
	private static int count;

	/* Service layer calling */
	private DirectionServiceMethods dirServ = new DirectionServiceImpl();

	private List<Direction> listDir;

	private String success;

	private String id;
	private String operation;

	public DirectionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		listDir = dirServ.findAll();
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;
	}

	public void showformAction(ActionEvent e) {
		nomDir = "";
		chefDir = "";
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

	public void buttonAction(ActionEvent actionEvent) {
		addMessage("Welcome to Primefaces!!");
		System.out.println("hello");
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void ajouter(ActionEvent e) {

		Direction d = null;

		System.out.println("Test : " + operation + " " + id);

		if ("modifier".equalsIgnoreCase(operation)) {

			d = dirServ.findById(Integer.valueOf(id));
			if ("".equalsIgnoreCase(nomDir) || "".equalsIgnoreCase(chefDir)) {
				if ("".equalsIgnoreCase(nomDir)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom vide : Vous devez indiquer une valeur, ex : DRH"));
				}
				if ("".equalsIgnoreCase(chefDir)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Vous devez indiquer un Nom pour le chef."));

				}
			} else {
				d.setNomDir(nomDir);
				d.setChefDir(chefDir);

				dirServ.edite(d);
				listDir = dirServ.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Direction Modifié avec succée"));
				System.out.println("success edite");
				setShowform(false);
			}
		} else {
			d = new Direction();
			if ("".equalsIgnoreCase(nomDir) || "".equalsIgnoreCase(chefDir)) {
				if ("".equalsIgnoreCase(nomDir)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom vide : Vous devez indiquer une valeur, ex : DRH"));
				}
				if ("".equalsIgnoreCase(chefDir)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Vous devez indiquer un Nom pour le chef."));

				}
			} else {
				d.setNomDir(nomDir);
				d.setChefDir(chefDir);

				dirServ.add(d);
				listDir = dirServ.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Direction ajouté"));

				System.out.println("success add");
				setShowform(false);
			}
		}

		nomDir = "";
		chefDir = "";

		success = "Direction ajouté";
		id = "";
		operation = "";
	}

	public void supprimer(ActionEvent e) {
		System.out.println("Direction supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		try {
			dirServ.delete(new Integer(param.get("id")));
			listDir = dirServ.findAll();
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
					"Direction " + param.get("n") + " a été supprimé"));
		} catch (Exception e2) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
					"On ne peut supprimer cette Direction, c'est un clé étrangère dans la table service"));
			System.err.println(e2);
		}

	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int idDir = Integer.valueOf(param.get("id"));
		Direction dir = dirServ.findById(idDir);
		nomDir = dir.getNomDir();
		chefDir = dir.getChefDir();
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public void viderFormulaire(ActionEvent e) {
		nomDir = "";
		chefDir = "";
		System.out.println("hello");
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		DirectionBean.count = count;
	}

	public boolean isShowData() {
		return showData;
	}

	public void setShowData(boolean showData) {
		this.showData = showData;
	}

	public boolean isShowform() {
		return showform;
	}

	public void setShowform(boolean showform) {
		this.showform = showform;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public List<Direction> getListDir() {
		return listDir;
	}

	public void setListDir(List<Direction> listDir) {
		this.listDir = listDir;
	}

	public String getIdDir() {
		return idDir;
	}

	public void setIdDir(String idDir) {
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
