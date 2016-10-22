package com.Amendis.GestionParc.DAO.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "installation_logiciel")
public class InstallationLogiciel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInstallation;
	private int idInstMat;
	private int idInstLog;
	private Date dateInst;

	public InstallationLogiciel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstallationLogiciel(int idInstMat, int idInstLog) {
		this.idInstMat = idInstMat;
		this.idInstLog = idInstLog;
	}

	public InstallationLogiciel(int idInstalation, int idInstMat, int idInstLog, Date dateInst) {
		this.idInstallation = idInstalation;
		this.idInstMat = idInstMat;
		this.idInstLog = idInstLog;
		this.dateInst = dateInst;
	}

	public InstallationLogiciel(int idInstMat, int idInstLog, Date dateInst) {
		this.idInstMat = idInstMat;
		this.idInstLog = idInstLog;
		this.dateInst = dateInst;
	}

	public int getIdInstalation() {
		return idInstallation;
	}

	public void setIdInstalation(int idInstalation) {
		this.idInstallation = idInstalation;
	}

	public int getIdInstMat() {
		return idInstMat;
	}

	public void setIdInstMat(int idInstMat) {
		this.idInstMat = idInstMat;
	}

	public int getIdInstLog() {
		return idInstLog;
	}

	public void setIdInstLog(int idInstLog) {
		this.idInstLog = idInstLog;
	}

	public Date getDateInst() {
		return dateInst;
	}

	public void setDateInst(Date dateInst) {
		this.dateInst = dateInst;
	}

}
