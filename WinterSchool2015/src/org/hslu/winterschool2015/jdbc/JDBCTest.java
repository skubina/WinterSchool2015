package org.hslu.winterschool2015.jdbc;



//Zum Testen der Datenbankverbindung, starten sie diese Klasse mit "run as -> run on server"

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hslu.winterschool2015.beans.TableBuilder;



/**
 * Servlet implementation class JDBCTest
 */
@WebServlet("/JDBCTest")
public class JDBCTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		
		Connection dbConn = new JDBCAccess().getConnection();
		String sql = "SELECT * FROM PERSONEN";
		String tabelle = "";
		PreparedStatement myPrep;
		try {
			myPrep = dbConn.prepareStatement(sql);
			ResultSet dbRes = myPrep.executeQuery();
			TableBuilder tableBuilder = new TableBuilder();
			tabelle = tableBuilder.buildTable(dbRes);
			tabelle = "Die Datenbank Verbindung funktioniert! <br/>" + tabelle;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output.print("<html>");
			output.print("<head>");
				output.print("<title>TEST</title>");
			output.print("<head>");
			output.print("<body>");
				output.print(tabelle);
			output.print("</body>");
		output.print("</html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
