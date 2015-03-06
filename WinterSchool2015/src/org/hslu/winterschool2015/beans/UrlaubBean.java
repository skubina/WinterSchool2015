package org.hslu.winterschool2015.beans;

public class UrlaubBean {
	
	String urlaubsListe;
	
	
	
	public void addZielRating(String ziel, String rating){
		this.urlaubsListe = 
				this.urlaubsListe + "<tr><td>" + ziel + "</td>";
		
		this.urlaubsListe = 
				this.urlaubsListe + "<td>"+ rating + "</td></tr>";
	}
	

	public UrlaubBean() {
		super();
		// TODO Auto-generated constructor stub
		this.urlaubsListe = "";
	}

	public String getUrlaubsListe() {
		return urlaubsListe;
	}

	public void setUrlaubsListe(String urlaubsListe) {
		this.urlaubsListe = urlaubsListe;
	}
	
	
	
	
	

}
