package org.hslu.winterschool2015.beans;

import java.util.Iterator;
import java.util.LinkedList;

public class PersonenListeBean {
	
	LinkedList<PersonenBean>	 personenListe;
	String		 personenListeHtml;
	
	
	
	
	
	
	public void buildPersonenListeHtml(){
		
		Iterator<PersonenBean> personenListeIter = personenListe.iterator();
		
		PersonenBean tempPerson;
		
		while(personenListeIter.hasNext()){	
			tempPerson = personenListeIter.next();
			
			this.personenListeHtml = this.personenListeHtml + tempPerson.getVorname() + " <br /> ";
			this.personenListeHtml = this.personenListeHtml + tempPerson.getNachname() + " <br /> ";
			this.personenListeHtml = this.personenListeHtml + tempPerson.getAdresse() + " <br /><br /> ";
			
		}
		
	}
	
	
	
	public void addPerson(PersonenBean person){
		personenListe.add(person);
	}
	
	
	
	
	
	public PersonenListeBean() {
		super();
		this.personenListe = new LinkedList();
		this.personenListeHtml = "";
	}
	
	
	
	public LinkedList<PersonenBean> getPersonenListe() {
		return personenListe;
	}
	public void setPersonenListe(LinkedList<PersonenBean> personenListe) {
		this.personenListe = personenListe;
	}
	public String getPersonenListeHtml() {
		return personenListeHtml;
	}
	public void setPersonenListeHtml(String personenListeHtml) {
		this.personenListeHtml = personenListeHtml;
	}
	
	
	

}
