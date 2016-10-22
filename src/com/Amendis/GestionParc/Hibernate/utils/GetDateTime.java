package com.Amendis.GestionParc.Hibernate.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class GetDateTime {

	public static String nowString(){
		return new DateTime().toString(DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss" ));
	}
	
	public static Date now(){
		return new Date();
	}
}
