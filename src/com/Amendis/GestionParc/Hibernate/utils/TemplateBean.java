package com.Amendis.GestionParc.Hibernate.utils;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.Amendis.GestionParc.Service.FournisseurServiceImpl;
import com.Amendis.GestionParc.Service.FournisseurServiceMethods;
@ManagedBean
@ViewScoped
public class TemplateBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/*private String nom;
	private boolean showform;
	private boolean showData;
	private static int count;

	 Service layer calling 
	private ServiceMethods Serv = new ServiceImpl();
	 params list declaration 
	private List<TemplateBean> list;

	private String success;
	private String id;
	private String operation;

	@PostConstruct
	public void init() {
		list = Serv.findAll();
		nom = "Cacher";
		showform = false;
		showData= true;
		count = 1;
	}
	public void showformAction(ActionEvent e) {
		nomDir = "";
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

*/	
}
