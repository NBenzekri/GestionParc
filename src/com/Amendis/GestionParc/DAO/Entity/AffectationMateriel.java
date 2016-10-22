package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "affectation_materiel")
public class AffectationMateriel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAff;
	private int idMatAff;
	private int matAgentAff;
	private Date dateAff;

	public AffectationMateriel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectationMateriel(int idMatAff, int matAgentAff) {
		this.idMatAff = idMatAff;
		this.matAgentAff = matAgentAff;
	}

	public AffectationMateriel(int idAff, int idMatAff, int matAgentAff, Date dateAff) {
		this.idAff = idAff;
		this.idMatAff = idMatAff;
		this.matAgentAff = matAgentAff;
		this.dateAff = dateAff;
	}

	public AffectationMateriel(int idMatAff, int matAgentAff, Date dateAff) {
		this.idMatAff = idMatAff;
		this.matAgentAff = matAgentAff;
		this.dateAff = dateAff;
	}

	public int getIdAff() {
		return idAff;
	}

	public void setIdAff(int idAff) {
		this.idAff = idAff;
	}

	public int getIdMatAff() {
		return idMatAff;
	}

	public void setIdMatAff(int idMatAff) {
		this.idMatAff = idMatAff;
	}

	public int getMatAgentAff() {
		return matAgentAff;
	}

	public void setMatAgentAff(int idAgentAff) {
		this.matAgentAff = idAgentAff;
	}

	public Date getDateAff() {
		return dateAff;
	}

	public void setDateAff(Date dateAff) {
		this.dateAff = dateAff;
	}

}
