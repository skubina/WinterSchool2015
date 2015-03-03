<%@ page import="org.hslu.winterschool2015.beans.CounterBean" %>
<html>

	<head>
		<title>New File :)</title>
	</head>

	<body>
	
	<jsp:useBean id="counter" class="org.hslu.winterschool2015.beans.CounterBean"  scope="session"  />
	
		Hallo Welt - JSP <br />
		

		
		<form action="HalloWeltAppl">
			<input type="text" name="print"><br />
			<input type="submit" value="Add Value"  name="submit" ><br />
		</form>
		
		
	<input type="text"  value="<jsp:getProperty property="meineZahlString"  name="counter" />" />
	
	</body>



</html>