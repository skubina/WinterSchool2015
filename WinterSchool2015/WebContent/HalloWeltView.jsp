<%@ page import="org.hslu.winterschool2015.beans.CounterBean" %>
<html>

	<head>
		<title>New File :)</title>
	</head>

	<body>
	
	<jsp:useBean id="counter" class="org.hslu.winterschool2015.beans.CounterBean"  scope="session"  />
	
		Hallo Welt - JSP <br />
		

		
		<form action="HalloWeltAppl">
			<input type="text" name="textField1" value="<jsp:getProperty property="meineZahlString"  name="counter" />" /><br />
			<input type="text" name="textField2" /><br />
			<input type="submit" value="add"  name="submit"  /><br />
			<input type="submit" value="sub"  name="submit"  /><br />
			<input type="submit" value="mul"  name="submit"  /><br />
			<input type="submit" value="div"  name="submit"  /><br />
		</form>
		
		
	<jsp:getProperty property="meineZahlString"  name="counter" />
	
	</body>



</html>