<%@ page import="org.hslu.winterschool2015.beans.CounterBean" %>
<html>

	<head>
		<title>Nw File :)</title>
	</head>

	<body>
	
		Hallo Welt - JSP <br />
		
		<%

		
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

				
				out.append("<a href=\"HalloWelt.jsp?print=4\" >Print 4!</a> <br />");
				out.append("<a href=\"HalloWelt.jsp?print=5\" >Print 5!</a> <br />");
				out.append(meinCounter.getMeineZahlString());

		%>
	
	</body>



</html>