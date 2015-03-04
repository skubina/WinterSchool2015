package org.hslu.winterschool2015.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hslu.winterschool2015.jdbc.JDBCAccess;

public class SqlTester {

	public static void main(String[] args) {
		SqlTester tester = new SqlTester();
		
		
		//tester.addPerson("Klaus", "Freyburger", "567");
		//tester.addPerson("Gordon", "Shumway", "Melmark");
		//tester.addPerson("The", "Doctor", "Gallayfrey");
		//tester.truncateTable();
		
		tester.removePerson(5);
		
		tester.printTable();
	}
	
	public void removePerson(int id){
		
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
	
	public void truncateTable(){
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
	
	public void addPerson(String vorname, String nachname, String adresse){
		
		Connection dbConn = new JDBCAccess().getConnection();
		
		String sql = "INSERT INTO PERSONEN (VORNAME, NACHNAME, ADRESSE) " +
		"VALUES ('" + vorname + "', '" + nachname + "', '" + adresse + "') ";
		
		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);
			myPrep.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void printTable(){
		Connection dbConn = new JDBCAccess().getConnection();
		String sql = "SELECT * FROM PERSONEN";

		try {
			PreparedStatement myPrep = dbConn.prepareStatement(sql);

			ResultSet dbRes = myPrep.executeQuery();

			while (dbRes.next()) {
				System.out.println("ID: " 		+ dbRes.getInt("ID"));
				System.out.println("VORNAME: " 	+ dbRes.getString("VORNAME"));
				System.out.println("NACHNAME: " + dbRes.getString("NACHNAME"));
				System.out.println("ADRESSE: " 	+ dbRes.getString("ADRESSE"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
