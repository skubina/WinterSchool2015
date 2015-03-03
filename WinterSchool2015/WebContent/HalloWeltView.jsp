<%@ page import="org.hslu.winterschool2015.beans.CounterBean" %>
<html>

	<head>
		<title>Nw File :)</title>
	</head>

	<body>
	
		Hallo Welt - JSP <br />
		
		<%

		CounterBean meinCounter = (CounterBean) session.getAttribute("counter");
	
				out.append("<a href=\"HalloWeltAppl?print=4\" >Print 4!</a> <br />");
				out.append("<a href=\"HalloWeltAppl?print=5\" >Print 5!</a> <br />");
				out.append(meinCounter.getMeineZahlString());

		%>
	
	</body>



</html>