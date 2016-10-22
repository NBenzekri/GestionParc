package com.Amendis.GestionParc.Hibernate.utils;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.Amendis.GestionParc.DAO.*;
import com.Amendis.GestionParc.DAO.Entity.*;
import com.Amendis.GestionParc.Vue.ServiceBean;

public class Test {

	static Session session = HibernateUtil.openSession();

	public static Logger log = Logger.getLogger(Test.class);

	public static void logicielTest() {
		LogicielDAOMethods dao = new LogicielDAOImpl();

		// add
		dao.add(new Logiciel("log x", "gegd", "5.0", "edd", "1457"));
//		dao.add(new Logiciel("l1", "l1", "1.0", "aaa", "123455", GetDateTime.now()));
//		dao.add(new Logiciel("l2", "l1", "12.0", "aajjja", "123455", GetDateTime.now()));
//		dao.add(new Logiciel("l3", "l15", "11.0", "ahhaa", "123455", GetDateTime.now()));
//		dao.add(new Logiciel("l4", "l15", "12.0", "ahhaa", "123455", GetDateTime.now()));
//
//		// edite
//		Logiciel a = dao.findById(2);
//		a.setVersionL("3.0");
//		a.setEditeurL("zzz");
//		dao.edite(a);
//
//		// delete
//		dao.delete(3);
//
//		// show all
//		List<Logiciel> ser = dao.findAll();
//		for (Logiciel v : ser) {
//			System.out.println(v.getIdL() + ", " + v.getNomL() + ", " + v.getDateL() +", " + v.getNomL());
//		}
	}

	public static void FournisseurTest() {
		FournisseurDAOMethods dao = new FournisseurDAOImpl();

		// add
		dao.add(new Fournisseur("f4", "em1", "adr1", "06666"));
		dao.add(new Fournisseur("f5", "em12", "adr21", "066662"));
		dao.add(new Fournisseur("f6", "em12", "adr21", "066662"));

		// edite
		Fournisseur a = dao.findById(2);
		a.setAddrFourn("newadr");
		dao.edite(a);

		// delete
		dao.delete(3);

		// show all
		List<Fournisseur> ser = dao.findAll();
		for (Fournisseur v : ser) {
			System.out.println(v.getIdFourn() + ", " + v.getNomFourn() + ", " + v.getAddrFourn());
		}
	}

	public static void agenceTest() {
		AgenceDAOMethods dao = new AgenceDAOImpl();

		// add
		dao.add(new Agence("ag11", "adr5", new Date()));
		dao.add(new Agence("ag12", "adr6", GetDateTime.now()));

		// edite
		Agence a = dao.findById(5);
		a.setDate(new Date());
		a.setAddrAgence("adr55");
		dao.edite(a);

		// delete
		dao.delete(6);

		// show all
		List<Agence> ser = dao.findAll();
		for (Agence v : ser) {
			System.out
					.println(v.getIdAgence() + ", " + v.getNomAgence() + ", " + v.getAddrAgence() + ", " + v.getDate());
		}
	}

	public static void InstallationLogicielTest() {
		InstallationLogicielDAOMethods dao = new InstallationLogicielDAOImpl();

		// add
		dao.add(new InstallationLogiciel(2, 4));
		dao.add(new InstallationLogiciel(2, 5, GetDateTime.now()));
		dao.add(new InstallationLogiciel(2, 5));
		dao.add(new InstallationLogiciel(2, 2));

		// edite
		InstallationLogiciel a = dao.findById(3);
		a.setIdInstLog(6);
		a.setIdInstMat(4);
		dao.edite(a);

		// delete
		dao.delete(6);

		// show all
		List<InstallationLogiciel> ser = dao.findAll();
		for (InstallationLogiciel v : ser) {
			System.out.println(v.getIdInstalation() + ", " + v.getIdInstMat() + ", " + v.getIdInstLog() );
		}
	}

	public static void UserTest() {
		UserDAOMethods dao = new UserDAOImpl();

		// add
		dao.add(new User("user7", "123", "ng", "pgy", GetDateTime.now(), "a"));
		dao.add(new User("user8", "123", "gn", "py", GetDateTime.now(), "bv"));
		dao.add(new User("user9", "123", "gn", "pyy", GetDateTime.now(), "ba"));

		// edite
		User a = dao.findById(1);
		a.setLoginUser("user11");
		dao.edite(a);

		// delete
		dao.delete(3);

		// show all
		List<User> ser = dao.findAll();
		for (User v : ser) {
			System.out.println(v.getIdUser() + ", " + v.getLoginUser() + ", " + v.getDateAjoutUser());
		}
	}

	public static void AffectationMaterielTest() {
		
		AffectationMaterielDAOMethods dao = new AffectationMaterielDAOImpl();
		
		// add
		dao.add(new AffectationMateriel(1, 1000));
		dao.add(new AffectationMateriel(2, 1200));
		dao.add(new AffectationMateriel(4, 1300,new Date()));
		dao.add(new AffectationMateriel(4, 1400,new Date()));
		// edite
		AffectationMateriel a = dao.findById(4);
		a.setIdMatAff(2);
		a.setMatAgentAff(1200);
		dao.edite(a);

		// delete
//		dao.delete(2);

		// show all
		List<AffectationMateriel> ser = dao.findAll();
		for (AffectationMateriel v : ser) {
			Materiel m = new MaterielDAOImpl().findById(v.getIdMatAff());
			System.out.println(v.getIdAff() + ", " + v.getMatAgentAff() + ", " + m.getNomMat()+", "+ m.getNomMat());
		}
	}

	public static void agentTest() {
		AgentDAOMethods dao = new AgentDAOImpl();

		// add
		dao.add(new Agent(1200, "ag1", "p1511", "066666", "e@ee", "Base de données", "ag2"));

//		dao.add(new Agent(1200, "ag2", "p1211", "066666", "e@ee", "Base de données", "ag2"));
//		dao.add(new Agent(1300, "ag3", "p1211", "066666", "e@ee", "Base de données", "ag2"));
//		dao.add(new Agent(1400, "ag4", "p1114", "066666", "e@ee", "developpement", "ag2"));
		// edite
		Agent a = dao.findById(4);
		a.setAgenceAgent("ag1");
		dao.edite(a);

		// delete
		dao.delete(2);

		// show all
		List<Agent> ser = dao.findAll();
		for (Agent v : ser) {
			System.out.println(v.getIdAgent() + ", " + v.getMatAgent() + ", " + v.getNomAgent() + ", "
					+ v.getServAgent() + ", " + v.getAgenceAgent());
		}
	}

	public static void materielTest() {
		MaterielDAOMethods dao = new MaterielDAOImpl();

		// add
		dao.add(new Materiel(2, "bb", "pc acer", 2001.5, "12050", "15/02/2016", "2Go RAM", "1010c0012","02/09/2016", "0", 20, 0, 0, GetDateTime.now()));
		dao.add(new Materiel(1, "bb", "camera", 301.5, "12050", "15/02/2016", "2Go RAM", "1010v0012", "02/09/2016", "0", 46, 0, 0, GetDateTime.now()));
		dao.add(new Materiel(3, "bb", "HP", 4001.5, "12050", "15/02/2016", "4Go RAM", "1010004v12", "02/09/2016", "0", 30, 0, 0, GetDateTime.now()));
		dao.add(new Materiel(4, "bb", "HP", 4001.5, "12050", "15/02/2016", "4Go RAM", "1010004v12", "02/09/2016", "0", 30, 0, 0, GetDateTime.now()));


		// edite
		Materiel a = dao.findById(2);
		a.setTypeMat("photos");
		dao.edite(a);

//		// delete
		dao.delete(5);

		// show all
		List<Materiel> ser = dao.findAll();
		for (Materiel v : ser) {
			System.out.println(v.toString());
		}
	}

	public static void DirectionTest() {
		DirectionDAOMethods dao = new DirectionDAOImpl();

//		// add
//		dao.add(new Direction(nomDir, chefDir));
//		dao.add(new Direction("user8", "123", "gn", "py", GetDateTime.now(), "bv"));
//		dao.add(new Direction("user9", "123", "gn", "pyy", GetDateTime.now(), "ba"));
//
//		// edite
//		Direction a = dao.findById(1);
//		a.setLoginDirection("user11");
//		dao.edite(a);
//
//		// delete
//		dao.delete(3);

		// show all
		List<Direction> ser = dao.findAll();
		for (Direction v : ser) {
			System.out.println(v.getIdDir() + ", " + v.getNomDir() + ", " + v.getChefDir());
		}
	}

	public static void main(String[] args) {

	/*	Test.DirectionTest();
		*//**************//*
		ServiceBean d = new ServiceBean();
		
		d.init();
		for (Direction v : d.getDirList()) {
			System.out.println(v.getIdDir() + ", " + v.getNomDir() + ", " + v.getChefDir());
		}*/
		/***********
		 * 
		 * **/
		
		Test.logicielTest();
		
//		AdminDAOMethods Adao = new AdminDAOImpl();
//		Admin ad = null;
//		ad = Adao.valider("Nbenz", "123");
//		if(ad!=null)			
//		System.out.println(ad.getEmailAdmin()+" "+ad.getPasswordAdmin()+" "+ ad.toString());
//		else System.out.println("null data");
	}

}
