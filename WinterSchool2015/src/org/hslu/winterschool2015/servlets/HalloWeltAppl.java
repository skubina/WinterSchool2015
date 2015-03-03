package org.hslu.winterschool2015.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hslu.winterschool2015.beans.CounterBean;

/**
 * Servlet implementation class HalloWeltAppl
 */
@WebServlet("/HalloWeltAppl")
public class HalloWeltAppl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HalloWeltAppl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);

		CounterBean meinCounter = (CounterBean) session.getAttribute("counter");	
		if(meinCounter == null){
			meinCounter = new CounterBean();
		}
		
	
		String submitBtn = request.getParameter("submit");
		if(submitBtn == null){
			submitBtn = "";
		}
		
		String textField1 = request.getParameter("textField1");
		if( textField1 == null){
			 textField1 = "0";
		}
		
		String textField2 = request.getParameter("textField2");
		if( textField2 == null){
			 textField2 = "0";
		}
		
		try{
			int textField1Int = Integer.parseInt(textField1);
			int textField2Int = Integer.parseInt(textField2);
			
			
			meinCounter.setMeineZahl(textField1Int);
			
			
			if(submitBtn.equals("add")){
				
				meinCounter.addValue(textField2Int);
				
			} else if(submitBtn.equals("sub")){
				
				meinCounter.subValue(textField2Int);
				
			} else if(submitBtn.equals("mul")){
				
				meinCounter.mulValue(textField2Int);
				
			} else if(submitBtn.equals("div")){
				
				meinCounter.divValue(textField2Int);
				
			}
			
		}catch (Exception e){
			meinCounter.setMeineZahlString("Nur Zahlen als Eingabe gültig!");
		}
		
		session.setAttribute("counter", meinCounter);

		response.sendRedirect("HalloWeltView.jsp");
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
