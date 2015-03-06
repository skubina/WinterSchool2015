<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="org.hslu.winterschool2015.beans.UrlaubBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="urlaub"  class="org.hslu.winterschool2015.beans.UrlaubBean"   scope="session"  />

	<table border="1px">
		<tr>
			<th>Ziel</th>
			<th>Wertung</th>
		</tr>
	<jsp:getProperty property="urlaubsListe"  name="urlaub" /> 
	</table>
	
	<form action="UrlaubServlet">
		<input type="submit" value="new" name="new" />
		<input type="submit" value="clear" name="clear" />
	</form>

</body>
</html>