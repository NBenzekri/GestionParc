package com.Amendis.GestionParc.Vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.Amendis.GestionParc.DAO.Entity.*;
import com.Amendis.GestionParc.Service.*;

@ManagedBean
@ViewScoped
public class ServiceBean implements Serializable {

	private static final long serialVersionUID = 1L;


	private String idServ;
	private String nomServ;
	private String chefServ;
	private String dirServ;
	private String nom;

	private boolean showform;
	private boolean showData;
	private static int count;

	private List<Service> listServ;
	private List<Direction> dirList;
	private List<SelectItem> items;

	private String success;
	private String id;
	private String operation;
	private ServiceServiceMethods ServDAO = new ServiceServiceImpl();
	private DirectionServiceMethods DirDAO = new DirectionServiceImpl();

	@PostConstruct
	public void init() {
		listServ = ServDAO.findAll();
		dirList = DirDAO.findAll();

		items = new ArrayList<SelectItem>();

		for (Direction d : dirList) {
			items.add(new SelectItem(d.getIdDir(), d.getChefDir()));
		}
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;
	}

	public void showformAction(ActionEvent e) {
		nomServ = "";
		chefServ = "";
		dirServ = "0";
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

	public void ajouter(ActionEvent ae) {

		Service d = null;

		System.out.println("Test : " + operation + "--" + id);

		if ("modifier".equalsIgnoreCase(operation)) {
			if ("".equalsIgnoreCase(nomServ) || "".equalsIgnoreCase(chefServ) || "0".equalsIgnoreCase(dirServ)) {
				if ("".equalsIgnoreCase(nomServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom vide : Vous devez indiquer une valeur, ex : BDD"));
				}
				if ("".equalsIgnoreCase(chefServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Vous devez indiquer un Nom pour le chef."));

				}
				if ("0".equalsIgnoreCase(dirServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Vous devez selectioner une direction.", null));

				}
			} else {
				d = ServDAO.findById(Integer.valueOf(id));
				d.setNomServ(nomServ);
				d.setChefServ(chefServ);
				d.setDirServ(Integer.parseInt(dirServ));
				ServDAO.edite(d);
				listServ = ServDAO.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Service Modifié"));
				System.out.println("success edite");
				setShowform(false);
			}
		} else {

			d = new Service();
			if ("".equalsIgnoreCase(nomServ) || "".equalsIgnoreCase(chefServ) || "0".equalsIgnoreCase(dirServ)) {
				if ("".equalsIgnoreCase(nomServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom vide : Vous devez indiquer une valeur, ex : DRH"));
				}
				if ("".equalsIgnoreCase(chefServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Vous devez indiquer un Nom pour le chef."));

				}
				if ("0".equalsIgnoreCase(dirServ)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Vous devez selectioner une direction."));

				}
			} else {
				d.setNomServ(nomServ);
				d.setChefServ(chefServ);
				int a;
				try {
					a = Integer.parseInt(dirServ);

				} catch (NumberFormatException e) {
					a = 0;
				}
				d.setDirServ(a);
				ServDAO.add(d);
				listServ = ServDAO.findAll();
				dirList = DirDAO.findAll();

				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Service Ajouté"));
				setShowform(false);
				System.out.println("add");
			}
		}

		nomServ = "";
		chefServ = "";
		dirServ = "";

		id = "";
		operation = "";
	}
	
	public void supprimer(ActionEvent e) {
		System.out.println("Service supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		ServDAO.delete(new Integer(param.get("id")));
		listServ = ServDAO.findAll();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Service " + param.get("ns") +" a été  supprimee"));
	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int idServ = Integer.valueOf(param.get("id"));
		Service Serv = ServDAO.findById(idServ);
		nomServ = Serv.getNomServ();
		chefServ = Serv.getChefServ();
		dirServ = Integer.toString(Serv.getDirServ());
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public void viderFormulaire(ActionEvent e) {
		nomServ = "";
		chefServ = "";
	}

	public List<SelectItem> getItems() {
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public String getIdServ() {
		return idServ;
	}

	public List<Direction> getDirList() {
		return dirList;
	}

	public void setDirList(List<Direction> dirList) {
		this.dirList = dirList;
	}

	public void setIdServ(String idServ) {
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

	public String getDirServ() {
		return dirServ;
	}

	public void setDirServ(String dirServ) {
		this.dirServ = dirServ;
	}

	public List<Service> getListServ() {
		return listServ;
	}

	public void setListServ(List<Service> listServ) {
		this.listServ = listServ;
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

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		ServiceBean.count = count;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
