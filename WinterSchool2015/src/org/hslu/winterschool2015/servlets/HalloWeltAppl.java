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
	
		String meinParameter = request.getParameter("print");
		if(meinParameter == null){
			meinParameter = "0";
		}
		
		int meinParameterInt = Integer.parseInt(meinParameter);
		meinCounter.addValue(meinParameterInt);
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
