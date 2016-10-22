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
@Table(name = "logiciel")
public class Logiciel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idL;
	private String nomL;
	private String licenceL;
	private String versionL;
	private String editeurL;
	private String numSerieL;
	@Column(name = "dateL", columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP")
	private Date dateL;

	public Logiciel(String nomL, String licenceL, String versionL, String editeurL, String numSerieL) {
		this.nomL = nomL;
		this.licenceL = licenceL;
		this.versionL = versionL;
		this.editeurL = editeurL;
		this.numSerieL = numSerieL;
	}

	public Logiciel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logiciel(int idL, String nomL, String licenceL, String versionL, String editeurL, String numSerieL,
			Date dateL) {
		this.idL = idL;
		this.nomL = nomL;
		this.licenceL = licenceL;
		this.versionL = versionL;
		this.editeurL = editeurL;
		this.numSerieL = numSerieL;
		this.dateL = dateL;
	}

	public Logiciel(String nomL, String licenceL, String versionL, String editeurL, String numSerieL, Date dateL) {
		this.nomL = nomL;
		this.licenceL = licenceL;
		this.versionL = versionL;
		this.editeurL = editeurL;
		this.numSerieL = numSerieL;
		this.dateL = dateL;
	}

	public int getIdL() {
		return idL;
	}

	public void setIdL(int idL) {
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

}
