package org.hslu.winterschool2015.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hslu.winterschool2015.beans.PersonenBean;
import org.hslu.winterschool2015.beans.PersonenListeBean;

/**
 * Servlet implementation class PersonenAppl
 */
@WebServlet("/PersonenAppl")
public class PersonenAppl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonenAppl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		PersonenListeBean personenListe = (PersonenListeBean) session.getAttribute("personenListe");
		if(personenListe == null){
			personenListe = new PersonenListeBean();
		}
		
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String adresse = request.getParameter("adresse");
		String submit = request.getParameter("submit");
		String clear = request.getParameter("clear");
		
		if(vorname == null){
			vorname = "";
		}
		if(nachname == null){
			nachname = "";
		}
		if(adresse == null){
			adresse = "";
		}
		if(submit == null){
			submit = "";
		}
		if(clear == null){
			clear = "";
		}
		
		
		if(submit.equals("Add Person")){
			PersonenBean person = new PersonenBean();
			person.setAdresse(adresse);
			person.setVorname(vorname);
			person.setNachname(nachname);
			
			personenListe.addPerson(person);
			personenListe.buildPersonenListeHtml();
			
			session.setAttribute("personenListe", personenListe);
			
			response.sendRedirect("PersonenListeView.jsp");
		}else if (clear.equals("clear")){
			
			/*
			personenListe.getPersonenListe().clear();
			personenListe.buildPersonenListeHtml();
			*/
			
			personenListe = new PersonenListeBean();
			session.setAttribute("personenListe", personenListe);
			
			response.sendRedirect("PersonenListeView.jsp");
			
		}else{
			response.sendRedirect("PersonenView.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
