package org.hslu.winterschool2015.beans;

public class CounterBean {
	
	int meineZahl;
	String meineZahlString;
	
	
	public CounterBean() {
		super();
		// TODO Auto-generated constructor stub
		
		this.meineZahl = 0;
		this.meineZahlString = "";
		
	}
	
	public void divValue(int meineNeueZahl){
		this.meineZahl = (int) ((double) this.meineZahl / (double) meineNeueZahl);
		this.meineZahlString = meineZahl + "";
	}
	
	public void mulValue(int meineNeueZahl){
		this.meineZahl = this.meineZahl * meineNeueZahl;
		this.meineZahlString = meineZahl + "";
	}
	
	public void subValue(int meineNeueZahl){
		this.meineZahl = this.meineZahl - meineNeueZahl;
		this.meineZahlString = meineZahl + "";
	}
	
	public void addValue(int meineNeueZahl){
		this.meineZahl = this.meineZahl + meineNeueZahl;
		this.meineZahlString = meineZahl + "";
	}


	public int getMeineZahl() {
		return meineZahl;
	}


	public void setMeineZahl(int meineZahl) {
		this.meineZahl = meineZahl;
	}


	public String getMeineZahlString() {
		return meineZahlString;
	}


	public void setMeineZahlString(String meineZahlString) {
		this.meineZahlString = meineZahlString;
	}
	
	
	
	
	
	
	
	
	

}
