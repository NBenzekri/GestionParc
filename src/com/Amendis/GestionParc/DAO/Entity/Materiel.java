package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materiel")
public class Materiel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMat;
	private int idFournMat;
	private String typeMat;
	private String nomMat;
	private double prixUnitaireMat;
	private String numBDCMat;
	private String dateAchatMat;
	private String descMat;
	private String numSerieMat;
	private String dateDebutGarantieMat;
	private String dureeGarantieMat;
	private int qteMat;
	private int qteEnServiceMat;
	private int qteHorsServiceMat;
	private Date dateAjoutMat;

	public Materiel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Materiel(int idMat, int idFournMat, String typeMat, String nomMat, double prixUnitaireMat, String numBDCMat,
			String dateAchatMat, String descMat, String numSerieMat, String dateDebutGarantieMat,
			String dureeGarantieMat, int qteMat, int qteEnServiceMat, int qteHorsServiceMat, Date dateAjoutMat) {
		this.idMat = idMat;
		this.idFournMat = idFournMat;
		this.typeMat = typeMat;
		this.nomMat = nomMat;
		this.prixUnitaireMat = prixUnitaireMat;
		this.numBDCMat = numBDCMat;
		this.dateAchatMat = dateAchatMat;
		this.descMat = descMat;
		this.numSerieMat = numSerieMat;
		this.dateDebutGarantieMat = dateDebutGarantieMat;
		this.dureeGarantieMat = dureeGarantieMat;
		this.qteMat = qteMat;
		this.qteEnServiceMat = qteEnServiceMat;
		this.qteHorsServiceMat = qteHorsServiceMat;
		this.dateAjoutMat = dateAjoutMat;
	}

	public Materiel(int idFournMat, String typeMat, String nomMat, double prixUnitaireMat, String numBDCMat,
			String dateAchatMat, String descMat, String numSerieMat, String dateDebutGarantieMat,
			String dureeGarantieMat, int qteMat, int qteEnServiceMat, int qteHorsServiceMat, Date dateAjoutMat) {
		this.idFournMat = idFournMat;
		this.typeMat = typeMat;
		this.nomMat = nomMat;
		this.prixUnitaireMat = prixUnitaireMat;
		this.numBDCMat = numBDCMat;
		this.dateAchatMat = dateAchatMat;
		this.descMat = descMat;
		this.numSerieMat = numSerieMat;
		this.dateDebutGarantieMat = dateDebutGarantieMat;
		this.dureeGarantieMat = dureeGarantieMat;
		this.qteMat = qteMat;
		this.qteEnServiceMat = qteEnServiceMat;
		this.qteHorsServiceMat = qteHorsServiceMat;
		this.dateAjoutMat = dateAjoutMat;
	}
	

	public Materiel(int idFournMat, String nomMat, double prixUnitaireMat, String numBDCMat, String dateAchatMat,
			int qteMat, Date dateAjoutMat) {
		this.idFournMat = idFournMat;
		this.nomMat = nomMat;
		this.prixUnitaireMat = prixUnitaireMat;
		this.numBDCMat = numBDCMat;
		this.dateAchatMat = dateAchatMat;
		this.qteMat = qteMat;
		this.dateAjoutMat = dateAjoutMat;
	}

	public int getIdMat() {
		return idMat;
	}

	public void setIdMat(int idMat) {
		this.idMat = idMat;
	}

	public int getIdFournMat() {
		return idFournMat;
	}

	public void setIdFournMat(int idFournMat) {
		this.idFournMat = idFournMat;
	}

	public String getTypeMat() {
		return typeMat;
	}

	public void setTypeMat(String typeMat) {
		this.typeMat = typeMat;
	}

	public String getNomMat() {
		return nomMat;
	}

	public void setNomMat(String nomMat) {
		this.nomMat = nomMat;
	}

	public double getPrixUnitaireMat() {
		return prixUnitaireMat;
	}

	public void setPrixUnitaireMat(double prixUnitaireMat) {
		this.prixUnitaireMat = prixUnitaireMat;
	}

	public String getNumBDCMat() {
		return numBDCMat;
	}

	public void setNumBDCMat(String numBDCMat) {
		this.numBDCMat = numBDCMat;
	}

	public String getDateAchatMat() {
		return dateAchatMat;
	}

	public void setDateAchatMat(String dateAchatMat) {
		this.dateAchatMat = dateAchatMat;
	}

	public String getDescMat() {
		return descMat;
	}

	public void setDescMat(String descMat) {
		this.descMat = descMat;
	}

	public String getNumSerieMat() {
		return numSerieMat;
	}

	public void setNumSerieMat(String numSerieMat) {
		this.numSerieMat = numSerieMat;
	}

	public String getDateDebutGarantieMat() {
		return dateDebutGarantieMat;
	}

	public void setDateDebutGarantieMat(String dateDebutGarantieMat) {
		this.dateDebutGarantieMat = dateDebutGarantieMat;
	}

	public String getDureeGarantieMat() {
		return dureeGarantieMat;
	}

	public void setDureeGarantieMat(String dureeGarantieMat) {
		this.dureeGarantieMat = dureeGarantieMat;
	}

	public int getQteMat() {
		return qteMat;
	}

	public void setQteMat(int qteMat) {
		this.qteMat = qteMat;
	}

	public int getQteEnServiceMat() {
		return qteEnServiceMat;
	}

	public void setQteEnServiceMat(int qteEnServiceMat) {
		this.qteEnServiceMat = qteEnServiceMat;
	}

	public int getQteHorsServiceMat() {
		return qteHorsServiceMat;
	}

	public void setQteHorsServiceMat(int qteHorsServiceMat) {
		this.qteHorsServiceMat = qteHorsServiceMat;
	}

	public Date getDateAjoutMat() {
		return dateAjoutMat;
	}

	public void setDateAjoutMat(Date dateAjoutMat) {
		this.dateAjoutMat = dateAjoutMat;
	}

}
