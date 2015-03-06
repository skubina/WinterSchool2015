package org.hslu.winterschool2015.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hslu.winterschool2015.beans.PersonenBean;

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

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			this.doAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.doAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void doAll(HttpServletRequest request, HttpServletResponse response) throws Exception{

		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		PersonenBean personenBean = (PersonenBean) session.getAttribute("personenBean");
		if(personenBean == null){
			personenBean = new PersonenBean();
		}
		
		//PersonenView
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String adresse = request.getParameter("adresse");
		String submit = request.getParameter("submit");
		//PersonenListeView
		String clear = request.getParameter("clear");
		String  delete = request.getParameter("delete");
		
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
		if(delete == null){
			delete = "";
		}
		
		if(submit.equals("Add Person")){
			
			personenBean.setAdresse(adresse);
			personenBean.setVorname(vorname);
			personenBean.setNachname(nachname);
			personenBean.addPerson();
			
			personenBean.printTable();
			
			session.setAttribute("personenBean", personenBean);
			response.sendRedirect("PersonenListeView.jsp");
		}else if (clear.equals("clear")){

			personenBean.truncateTable();
			personenBean.printTable();
			
			session.setAttribute("personenBean", personenBean);
			response.sendRedirect("PersonenListeView.jsp");
		}else if(!delete.equals("")){
			
			personenBean.removePerson(Integer.parseInt(delete));
			personenBean.printTable();
			
			session.setAttribute("personenBean", personenBean);
			response.sendRedirect("PersonenListeView.jsp");
		}else{
			response.sendRedirect("PersonenView.jsp");
		}

    }

}
