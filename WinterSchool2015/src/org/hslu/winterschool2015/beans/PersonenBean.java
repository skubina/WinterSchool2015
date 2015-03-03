package org.hslu.winterschool2015.beans;

public class PersonenBean {
	
	String vorname;
	String nachname;
	String adresse;
	
	
	public PersonenBean() {
		super();
		this.vorname = "";
		this.nachname = "";
		this.adresse = "";
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	

}
