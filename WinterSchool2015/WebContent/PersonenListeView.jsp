<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="org.hslu.winterschool2015.beans.PersonenListeBean" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="personenListe"  class="org.hslu.winterschool2015.beans.PersonenListeBean"   scope="session"  />

	<jsp:getProperty property="personenListeHtml"  name="personenListe" /> <br />
	
<br />
<br />
	<a href="PersonenAppl">Weitere Person hinzufügen</a>

</body>
</html>