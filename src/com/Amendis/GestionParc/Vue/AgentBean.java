package com.Amendis.GestionParc.Vue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.Amendis.GestionParc.DAO.Entity.Agence;
import com.Amendis.GestionParc.DAO.Entity.Agent;
import com.Amendis.GestionParc.DAO.Entity.Service;
import com.Amendis.GestionParc.Service.AgenceServiceImpl;
import com.Amendis.GestionParc.Service.AgenceServiceMethods;
import com.Amendis.GestionParc.Service.AgentServiceImpl;
import com.Amendis.GestionParc.Service.AgentServiceMethods;
import com.Amendis.GestionParc.Service.ServiceServiceImpl;
import com.Amendis.GestionParc.Service.ServiceServiceMethods;

@ManagedBean
@ViewScoped
public class AgentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idAgent;
	private String matAgent;
	private String nomAgent;
	private String prenomAgent;
	private String telAgent;
	private String emailAgent;
	private String servAgent;
	private String agenceAgent;
	private Date dateAjout;

	private boolean showform;
	private boolean showData;
	private String nom;
	private static int count;
	int nbr;

	// Service layer calling
	private AgentServiceMethods Serv = new AgentServiceImpl();
	private ServiceServiceMethods ServServ = new ServiceServiceImpl();
	private AgenceServiceMethods agenceServ = new AgenceServiceImpl();

	// params list declaration
	private List<Agent> list;
	private List<Agence> aglist;
	private List<Service> serlist;

	// SelectOneMenu Items:
	private List<SelectItem> itemsServ;
	private List<SelectItem> itemsAgence;

	private String success;
	private String id;
	private String operation;

	@PostConstruct
	public void init() {
		// agents list init
		list = Serv.findAll();

		// fill agent agence list to show it in the form
		aglist = agenceServ.findAll();

		itemsAgence = new ArrayList<SelectItem>();

		for (Agence d : aglist) {
			itemsAgence.add(new SelectItem(d.getNomAgence(), d.getNomAgence()));
		}
		/* fill agent service list to show it in the form */
		serlist = ServServ.findAll();

		itemsServ = new ArrayList<SelectItem>();

		for (Service d : serlist) {
			itemsServ.add(new SelectItem(d.getNomServ(), d.getNomServ()));
		}
		nom = "Cacher";
		showform = false;
		showData = true;
		count = 1;

	}

	
	public boolean isInt(String s) {
		boolean a = false;
		try{
			nbr = Integer.parseInt(s);
			a= true;
			
		}catch(NumberFormatException ex){
			a=false;
		}
			return a;
	}

	public void ajouter(ActionEvent ae) {

		Agent d = null;

		System.out.println("Test : Op: " + operation + "- ID: " + id);

		if ("modifier".equalsIgnoreCase(operation)) {
			d = Serv.findById(Integer.valueOf(id));
			if ("".equalsIgnoreCase(nomAgent) || "".equalsIgnoreCase(matAgent) || "0".equalsIgnoreCase(prenomAgent)) {
				if ("".equalsIgnoreCase(nomAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "le Nom est vide!"));
				}
				if ("".equalsIgnoreCase(matAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Donner la Matricule de l'Agent"));

				}
				if ("0".equalsIgnoreCase(prenomAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "le Prenom est vide!"));

				}
			} else {
				// Editing
				d.setNomAgent(nomAgent);
				try {
					d.setMatAgent(Integer.parseInt(matAgent));
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
				d.setPrenomAgent(prenomAgent);
				d.setAgenceAgent(agenceAgent);
				d.setServAgent(servAgent);
				d.setEmailAgent(emailAgent);
				d.setTelAgent(telAgent);
				d.setDateAjout(dateAjout);
				Serv.edite(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Agent Modifié"));
				System.out.println("success edite agent");
				setShowform(false);
			}
		} else {
			// Adding
			d = new Agent();
			if ("".equalsIgnoreCase(nomAgent) || "".equalsIgnoreCase(matAgent) || !isInt(matAgent) || "0".equalsIgnoreCase(prenomAgent)) {
				if ("".equalsIgnoreCase(nomAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "le Nom est vide!"));
				}
				if ("".equalsIgnoreCase(matAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "Donner la Matricule de l'Agent"));

				}
				if ("0".equalsIgnoreCase(prenomAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "le Prenom est vide!"));

				}
				if ( !isInt(matAgent)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur:", "la Matricule doit etre Numerique!"));

				}
			} else {

				d.setNomAgent(nomAgent);
				try {
					d.setMatAgent(Integer.parseInt(matAgent));
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
				d.setPrenomAgent(prenomAgent);
				d.setAgenceAgent(agenceAgent);
				d.setServAgent(servAgent);
				d.setEmailAgent(emailAgent);
				d.setTelAgent(telAgent);
				d.setDateAjout(new Date());
				Serv.add(d);
				list = Serv.findAll();
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Service Ajouté"));
				setShowform(false);
				System.out.println("add");
			}
		}

		matAgent = "";
		nomAgent = "";
		prenomAgent = "";
		telAgent = "";
		emailAgent = "";
		servAgent = "";
		agenceAgent = "";
		operation = "";

		id = "";
		operation = "";
	}

	public void supprimer(ActionEvent e) {
		System.out.println("Service supprimé");
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		System.out.println("id : " + param.get("id"));
		try {
			Serv.delete(new Integer(param.get("id")));
			list = Serv.findAll();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success",
					"Agent " + param.get("ns") + " a été  supprimee"));
		} catch (Exception e3) {
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur",
					"On ne peut supprimer cet Agent, c'est un clé étrangère dans autre tables!"));
			System.err.println(e3);
		}
	}

	public void modifier(ActionEvent e) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> param = fc.getExternalContext().getRequestParameterMap();
		int idServ = Integer.valueOf(param.get("id"));
		Agent ag = Serv.findById(idServ);
		nomAgent = ag.getNomAgent();
		matAgent = Integer.toString(ag.getMatAgent());
		prenomAgent = ag.getPrenomAgent();
		agenceAgent = ag.getAgenceAgent();
		servAgent = ag.getServAgent();
		telAgent = ag.getTelAgent();
		emailAgent = ag.getEmailAgent();
		dateAjout = ag.getDateAjout();
		setId(param.get("id"));
		setOperation(param.get("operation"));
		setShowform(true);
	}

	public void showformAction(ActionEvent e) {
		matAgent = "";
		nomAgent = "";
		prenomAgent = "";
		telAgent = "";
		emailAgent = "";
		servAgent = "";
		agenceAgent = "";
		operation = "";
		dateAjout = new Date();
		showform = true;
	}

	public void hideformAction(ActionEvent e) {
		showform = false;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public List<SelectItem> getItemsServ() {
		return itemsServ;
	}

	public void setItemsServ(List<SelectItem> itemsServ) {
		this.itemsServ = itemsServ;
	}

	public List<SelectItem> getItemsAgence() {
		return itemsAgence;
	}

	public void setItemsAgence(List<SelectItem> itemsAgence) {
		this.itemsAgence = itemsAgence;
	}

	public List<Agence> getAglist() {
		return aglist;
	}

	public void setAglist(List<Agence> aglist) {
		this.aglist = aglist;
	}

	public List<Service> getSerlist() {
		return serlist;
	}

	public void setSerlist(List<Service> serlist) {
		this.serlist = serlist;
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

	public String getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(String idAgent) {
		this.idAgent = idAgent;
	}

	public String getMatAgent() {
		return matAgent;
	}

	public void setMatAgent(String matAgent) {
		this.matAgent = matAgent;
	}

	public String getNomAgent() {
		return nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
	}

	public String getPrenomAgent() {
		return prenomAgent;
	}

	public void setPrenomAgent(String prenomAgent) {
		this.prenomAgent = prenomAgent;
	}

	public String getTelAgent() {
		return telAgent;
	}

	public void setTelAgent(String telAgent) {
		this.telAgent = telAgent;
	}

	public String getEmailAgent() {
		return emailAgent;
	}

	public void setEmailAgent(String emailAgent) {
		this.emailAgent = emailAgent;
	}

	public String getServAgent() {
		return servAgent;
	}

	public void setServAgent(String servAgent) {
		this.servAgent = servAgent;
	}

	public String getAgenceAgent() {
		return agenceAgent;
	}

	public void setAgenceAgent(String agenceAgent) {
		this.agenceAgent = agenceAgent;
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
		AgentBean.count = count;
	}

	public List<Agent> getList() {
		return list;
	}

	public void setList(List<Agent> list) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
