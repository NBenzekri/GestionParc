package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAgent;
	private int matAgent;
	private String nomAgent;
	private String prenomAgent;
	private String telAgent;
	private String emailAgent;
	private String servAgent;
	private String agenceAgent;
	@Column(name = "dateAjout", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private Date dateAjout;

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(int idAgent, int matAgent, String nomAgent, String prenomAgent, String telAgent, String emailAgent,
			String servAgent, String agenceAgent) {
		this.idAgent = idAgent;
		this.matAgent = matAgent;
		this.nomAgent = nomAgent;
		this.prenomAgent = prenomAgent;
		this.telAgent = telAgent;
		this.emailAgent = emailAgent;
		this.servAgent = servAgent;
		this.agenceAgent = agenceAgent;
	}

	public Agent(int matAgent, String nomAgent, String prenomAgent, String telAgent, String emailAgent,
			String servAgent, String agenceAgent) {
		this.matAgent = matAgent;
		this.nomAgent = nomAgent;
		this.prenomAgent = prenomAgent;
		this.telAgent = telAgent;
		this.emailAgent = emailAgent;
		this.servAgent = servAgent;
		this.agenceAgent = agenceAgent;
	}

	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public int getIdAgent() {
		return idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public int getMatAgent() {
		return matAgent;
	}

	public void setMatAgent(int matAgent) {
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

}
