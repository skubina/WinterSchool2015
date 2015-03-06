package org.hslu.winterschool2015.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hslu.winterschool2015.jdbc.JDBCAccess;

public class PersonenBean {

	int id;
	String vorname;
	String nachname;
	String adresse;

	String personenListeHtml;

	public PersonenBean() {
		super();
		this.vorname = "";
		this.nachname = "";
		this.adresse = "";
		this.personenListeHtml = "";
	}

	public void removePerson(int id) {

		Connection dbConn = new JDBCAccess().getConnection();

		String sql = "DELETE FROM PERSONEN WHERE ID =" + id;

		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);
			myPrep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void truncateTable() {
		Connection dbConn = new JDBCAccess().getConnection();

		String sql = "TRUNCATE PERSONEN";

		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);
			myPrep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addPerson() {

		Connection dbConn = new JDBCAccess().getConnection();

		String sql = "INSERT INTO PERSONEN (VORNAME, NACHNAME, ADRESSE) "
				+ "VALUES ('" + this.vorname + "', '" + this.nachname + "', '" + this.adresse
				+ "') ";

		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);
			myPrep.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void printTable() {
		Connection dbConn = new JDBCAccess().getConnection();
		String sql = "SELECT * FROM PERSONEN";
		this.personenListeHtml = "";
		
		
		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);

			ResultSet dbRes = myPrep.executeQuery();

			while (dbRes.next()) {
				System.out.println("ID: " + dbRes.getInt("ID"));
				System.out.println("VORNAME: " + dbRes.getString("VORNAME"));
				System.out.println("NACHNAME: " + dbRes.getString("NACHNAME"));
				System.out.println("ADRESSE: " + dbRes.getString("ADRESSE"));
				
				this.personenListeHtml = this.personenListeHtml + "<tr>";
				
				this.personenListeHtml = this.personenListeHtml +
						"<td>" + dbRes.getString("VORNAME") + "</td>";
				
				this.personenListeHtml = this.personenListeHtml +
						"<td>" + dbRes.getString("NACHNAME") + "</td>";
				
				this.personenListeHtml = this.personenListeHtml +
						"<td>" + dbRes.getString("ADRESSE") + "</td>";
				
				this.personenListeHtml = this.personenListeHtml +
						"<td><a href=\"PersonenAppl?delete=" + dbRes.getInt("ID") +   "\">delete</a></td>";
				
				this.personenListeHtml = this.personenListeHtml + "</tr>";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonenListeHtml() {
		return personenListeHtml;
	}

	public void setPersonenListeHtml(String personenListeHtml) {
		this.personenListeHtml = personenListeHtml;
	}

	
}
