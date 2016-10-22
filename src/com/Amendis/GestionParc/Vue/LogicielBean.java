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

import com.Amendis.GestionParc.Service.LogicielServiceImpl;
import com.Amendis.GestionParc.Service.LogicielServiceMethods;
import com.Amendis.GestionParc.DAO.Entity.Logiciel;

@ManagedBean
@ViewScoped
public class LogicielBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
	private boolean showform;
	private boolean showData;
	private static int count;

	/* Service layer calling */
	private LogicielServiceMethods Serv = new LogicielServiceImpl();

	/* params list declaration */
	private List<Logiciel> list;

	private String success;
	private String id;
	private String operation;

	private String idL;
	private String nomL;
	private String licenceL;
	private String versionL;
	private String editeurL;
	private String numSerieL;
	private Date dateL;

	@PostConstruct
	public void init() {
		list = Serv.findAll();
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;
	}

	public void ajouter(ActionEvent e) {

		Logiciel d = null;

		System.out.println("Test : " + operation + " " + id);

		if ("modifier".equalsIgnoreCase(operation)) {

			d = Serv.findById(Integer.valueOf(id));
			
			if ("".equalsIgnoreCase(nomL) || "".equalsIgnoreCase(numSerieL) || "".equalsIgnoreCase(licenceL)) {
				if ("".equalsIgnoreCase(nomL)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Erreur", "Nom de Logiciel vide!"));
				}
				if ("".equalsIgnoreCase(numSerieL)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur", "Chapms n° Serie doit etre non vide!"));

				}
				if ("".equalsIgnoreCase(licenceL)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erreur", "Chapms Licence doit etre non vide!"));

				}
			} else {
				d.setNomL(nomL);
				if (dateL == null)
					d.setDateL(new Date());
				else
					d.setDateL(dateL);
				d.setLicenceL(licenceL);
				d.setVersionL(versionL);
				d.setEditeurL(editeurL);
				d.setNumSerieL(numSerieL);

				Serv.edite(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success:", "Logiciel Modifié avec succée"));
				System.out.println("success edite");
				setShowform(false);
			}
		} else {
			d = new Logiciel();
			if ("".equalsIgnoreCase(nomL) || "".equalsIgnoreCase(numSerieL) || "".equalsIgnoreCase(licenceL)) {
				if ("".equalsIgnoreCase(nomL)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Nom de Logiciel vide!"));
				}
				if ("".equalsIgnoreCase(numSerieL)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Inserer le n° Série!"));

				}
				if ("".equalsIgnoreCase(licenceL)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Inserer la licence de !"));

				}
			} else {
				dateL = new Date();
				d.setNomL(nomL);
				d.setDateL(dateL);
				d.setLicenceL(licenceL);
				d.setVersionL(versionL);
				d.setEditeurL(editeurL);
				d.setNumSerieL(numSerieL);

				Serv.add(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success:", "Logiciel ajouté"));

				System.out.println("success add");
				setShowform(false);
			}
		}

		nomL = "";
		licenceL = "";
		versionL = "";
		editeurL = "";
		numSerieL = "";
		dateL = null;

		success = "Fournissuer ajouté";
		id = "";
		operation = "";
	}

	public void supprimer(ActionEvent e) {
		System.out.println("Logiciel supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		Serv.delete(new Integer(param.get("id")));
		list = Serv.findAll();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success:",
				"Fournissuer " + param.get("ns") + " a été supprimé"));
	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int id = Integer.valueOf(param.get("id"));
		Logiciel dir = Serv.findById(id);
		nomL = dir.getNomL();
		licenceL = dir.getLicenceL();
		versionL = dir.getVersionL();
		editeurL = dir.getEditeurL();
		numSerieL = dir.getNumSerieL();
		dateL = dir.getDateL();
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public void showformAction(ActionEvent e) {
		nomL = "";
		licenceL = "";
		versionL = "";
		editeurL = "";
		numSerieL = "";
		dateL = new Date();
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

	public String getIdL() {
		return idL;
	}

	public void setIdL(String idL) {
		this.idL = idL;
	}

	public String getNomL() {
		return nomL;
	}

	public void setNomL(String nomL) {
		this.nomL = nomL;
	}

	public String getLicenceL() {
		return licenceL;
	}

	public void setLicenceL(String licenceL) {
		this.licenceL = licenceL;
	}

	public String getVersionL() {
		return versionL;
	}

	public void setVersionL(String versionL) {
		this.versionL = versionL;
	}

	public String getEditeurL() {
		return editeurL;
	}

	public void setEditeurL(String editeurL) {
		this.editeurL = editeurL;
	}

	public String getNumSerieL() {
		return numSerieL;
	}

	public void setNumSerieL(String numSerieL) {
		this.numSerieL = numSerieL;
	}

	public Date getDateL() {
		return dateL;
	}

	public void setDateL(Date dateL) {
		this.dateL = dateL;
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
		LogicielBean.count = count;
	}

	public List<Logiciel> getList() {
		return list;
	}

	public void setList(List<Logiciel> list) {
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
