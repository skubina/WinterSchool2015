<html>

	<head>
		<title>Nw File :)</title>
	</head>

	<body>
	
		Hallo Welt - JSP <br />
		
		<%

		
		String meinString = (String) session.getAttribute("print");
		
		if(meinString == null){
			meinString = "0";
		}
	
		String meinParameter = request.getParameter("print");
		
		if(meinParameter == null){
			meinParameter = "0";
		}
		
		int meinParameterInt = Integer.parseInt(meinParameter);
		int meinStringInt = Integer.parseInt(meinString);
		int meinErgebenis = meinParameterInt + meinStringInt;
		
		meinString = ( Integer.parseInt(meinParameter) +Integer.parseInt(meinString)) + "" ;
	
		session.setAttribute("print", meinString);

				
				out.append("<a href=\"HalloWelt.jsp?print=4\" >Print 4!</a> <br />");
				out.append("<a href=\"HalloWelt.jsp?print=5\" >Print 5!</a> <br />");
				out.append(meinString);

		%>
	
	</body>



</html>