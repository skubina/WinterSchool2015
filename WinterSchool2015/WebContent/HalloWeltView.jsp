<%@ page import="org.hslu.winterschool2015.beans.CounterBean" %>
<html>

	<head>
		<title>New File :)</title>
	</head>

	<body>
	
	<jsp:useBean id="counter" class="org.hslu.winterschool2015.beans.CounterBean"  scope="session"  />
	
		Hallo Welt - JSP <br />
		
		<a href="HalloWeltAppl?print=4" >Print 4!</a> <br />
		<a href="HalloWeltAppl?print=5" >Print 5!</a> <br />
		
		
		
	<input type="text"  value="<jsp:getProperty property="meineZahlString"  name="counter" />" />
	
	</body>



</html>