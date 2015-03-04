package org.hslu.winterschool2015.beans;

import java.util.Iterator;
import java.util.LinkedList;

public class PersonenListeBean {
	
	LinkedList<PersonenBean>	 personenListe;
	String		 personenListeHtml;
	
	
	
	
	
	
	public void buildPersonenListeHtml(){
		this.personenListeHtml = "";
		
		Iterator<PersonenBean> personenListeIter = personenListe.iterator();
		
		PersonenBean tempPerson;
		int counter = 0;
		
		while(personenListeIter.hasNext()){	
			tempPerson = personenListeIter.next();
			
			this.personenListeHtml = this.personenListeHtml + "<tr>";
			this.personenListeHtml = this.personenListeHtml + "<td>" + tempPerson.getVorname() + "</td>";
			this.personenListeHtml = this.personenListeHtml + "<td>" +  tempPerson.getNachname() + "</td>";
			this.personenListeHtml = this.personenListeHtml + "<td>" +  tempPerson.getAdresse() + "</td>";
			this.personenListeHtml = this.personenListeHtml + "<td>" +
			"<a href=\"PersonenAppl?delete=" + counter + "\"> delete </a> " 
					+"</td>";
			this.personenListeHtml = this.personenListeHtml + "</tr>";
			
			counter++;
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
