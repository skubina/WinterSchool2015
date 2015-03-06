package org.hslu.winterschool2015.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCAccess {
	String dbDriverName;
	String dbURL;
	String dbUser;
	String dbPassword;
	// String dbSchema;
	Connection dbConn = null;

	public JDBCAccess() {
		this.setDBParms();
		this.createConnection();
		// this.setSchema();
	}

	// Setzen der benötigten Zugangsdaten
	public void setDBParms() {
		dbDriverName = "com.mysql.jdbc.Driver";
		dbURL = "jdbc:mysql://derbe-frisiert.com/d01d758a";
		dbUser = "d01d758a";
		dbPassword = "winterschool2015";
	}

	public void createConnection() {
		Class<?> driverClass;
		try {
			driverClass = Class.forName(dbDriverName);
			System.out.println(driverClass.getName() + "geladen");
			dbConn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			System.out.println("Datenbankverbindung wurde hergestellt");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConnection() {
		return dbConn;
	}
}
