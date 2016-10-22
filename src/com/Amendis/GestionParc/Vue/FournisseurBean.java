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

import com.Amendis.GestionParc.DAO.Entity.Fournisseur;
import com.Amendis.GestionParc.Service.FournisseurServiceImpl;
import com.Amendis.GestionParc.Service.FournisseurServiceMethods;

@ManagedBean
@ViewScoped
public class FournisseurBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idFourn;
	private String nomFourn;
	private String emailFourn;
	private String addrFourn;
	private String telFourn;

	private String nom;
	private boolean showform;
	private boolean showData;
	private static int count;

	/* Service layer calling */
	private FournisseurServiceMethods fournServ = new FournisseurServiceImpl();

	private List<Fournisseur> listFourn;

	private String success;
	private String id;
	private String operation;

	@PostConstruct
	public void init() {
		listFourn = fournServ.findAll();
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;
	}

	public void ajouter(ActionEvent e) {

		Fournisseur d = null;

		System.out.println("Test : " + operation + " " + id);

		if ("modifier".equalsIgnoreCase(operation)) {

			d = fournServ.findById(Integer.valueOf(id));
			if ("".equalsIgnoreCase(nomFourn) || "".equalsIgnoreCase(emailFourn) || "".equalsIgnoreCase(addrFourn)
					|| "".equalsIgnoreCase(telFourn)) {
				if ("".equalsIgnoreCase(nomFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom de fournisseur vide!"));
				}
				if ("".equalsIgnoreCase(emailFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Chapms Email doit etre non vide!"));

				}
				if ("".equalsIgnoreCase(telFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Chapms Email doit etre non vide!"));

				}
			} else {
				d.setNomFourn(nomFourn);
				d.setAddrFourn(addrFourn);
				d.setEmailFourn(emailFourn);
				d.setTelFourn(telFourn);
				fournServ.edite(d);
				listFourn = fournServ.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Fournissuer Modifié avec succée"));
				System.out.println("success edite");
				setShowform(false);
			}
		} else {
			d = new Fournisseur();
			if ("".equalsIgnoreCase(nomFourn) || "".equalsIgnoreCase(emailFourn) || "".equalsIgnoreCase(addrFourn)
					|| "".equalsIgnoreCase(telFourn)) {
				if ("".equalsIgnoreCase(nomFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Nom de fournisseur vide!"));
				}
				if ("".equalsIgnoreCase(emailFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Chapms Email vide!"));

				}
				if ("".equalsIgnoreCase(telFourn)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"erreur", "Chapms Telephone est vide!"));

				}
			} else {
				d.setNomFourn(nomFourn);
				d.setAddrFourn(addrFourn);
				d.setEmailFourn(emailFourn);
				d.setTelFourn(telFourn);

				fournServ.add(d);
				listFourn = fournServ.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Fournissuer ajouté"));

				System.out.println("success add");
				setShowform(false);
			}
		}

		idFourn = "";
		nomFourn = "";
		emailFourn = "";
		addrFourn = "";
		telFourn = "";

		success = "Fournissuer ajouté";
		id = "";
		operation = "";
	}

	public void supprimer(ActionEvent e) {
		System.out.println("Fournissuer supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		fournServ.delete(new Integer(param.get("id")));
		listFourn = fournServ.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
				"Fournissuer " + param.get("ns") + " a été supprimé"));
	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int idDir = Integer.valueOf(param.get("id"));
		Fournisseur dir = fournServ.findById(idDir);
		nomFourn = dir.getNomFourn();
		emailFourn = dir.getEmailFourn();
		addrFourn = dir.getAddrFourn();
		telFourn = dir.getTelFourn();
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public void showformAction(ActionEvent e) {
		idFourn = "";
		nomFourn = "";
		emailFourn = "";
		addrFourn = "";
		telFourn = "";
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

	public List<Fournisseur> getListFourn() {
		return listFourn;
	}

	public void setListFourn(List<Fournisseur> listFourn) {
		this.listFourn = listFourn;
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

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		FournisseurBean.count = count;
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

	public String getIdFourn() {
		return idFourn;
	}

	public void setIdFourn(String idFourn) {
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
