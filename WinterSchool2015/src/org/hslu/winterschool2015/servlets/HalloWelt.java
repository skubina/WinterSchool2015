package org.hslu.winterschool2015.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HalloWelt
 */
@WebServlet("/HalloWelt")
public class HalloWelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HalloWelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter meinWriter = response.getWriter();
		
		String meinParameter = request.getParameter("print");
		if(meinParameter == null){
			meinParameter = "";
		}
		
		meinWriter.append("<html> \n");
		
			meinWriter.append("<head> \n");
			meinWriter.append("</head> \n");
			
			meinWriter.append("<body> \n");
				meinWriter.append("Hallo Welt! \n");
				meinWriter.append( (2 * 3) + "<br />" );
				
				meinWriter.append("<a href=\"HalloWelt?print=4\" >Print 4!</a> <br />");
				meinWriter.append("<a href=\"HalloWelt?print=5\" >Print 5!</a> <br />");
				meinWriter.append(meinParameter);
				
			meinWriter.append("</body> \n");
			
		meinWriter.append("</html> \n");
		
		System.out.println("Hallo Welt!");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
