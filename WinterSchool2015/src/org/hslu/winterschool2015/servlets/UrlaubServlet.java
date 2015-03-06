package org.hslu.winterschool2015.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hslu.winterschool2015.beans.UrlaubBean;

/**
 * Servlet implementation class UrlaubServlet
 */
@WebServlet("/UrlaubServlet")
public class UrlaubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrlaubServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//Session holen
		HttpSession session = request.getSession(true);
		//Objekt urlaub vom Typ UrlaubBean aus Session holen
		UrlaubBean urlaub = (UrlaubBean) session.getAttribute("urlaub");
		//Wenn Objekt urlaub trozdem null, dann neues Objekt vom Typ UrlaubBean
		if(urlaub == null){
			urlaub = new UrlaubBean();
		}
		
		
		//Parameter aus Request holen 
		//(Request von AddView)
		String ziel 	= request.getParameter("ziel");
		String rating 	= request.getParameter("rating");
		String add 		= request.getParameter("add");
		//Parameter de-null-ifien
		if(ziel == null){
			ziel = "";
		}
		if(rating == null){
			rating = "";
		}
	
		
		
		
		
		//Aktionsweiche
		//Button gedrückt wenn add NICHT null
		if(add != null){
		
			//Ruft Methode zum erweitern der Tabelle auf
			urlaub.addZielRating(ziel, rating);
			//Setzt verändertes Objekt urlaub in Session
			session.setAttribute("urlaub", urlaub);
			//Sendet Client an die url ./UrlaubView.jsp
			response.sendRedirect("UrlaubView.jsp");
		}
		
		else {
			response.sendRedirect("AddView.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
