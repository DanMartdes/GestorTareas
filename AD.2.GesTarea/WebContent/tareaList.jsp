<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="modelo.ListaTarea" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tareas Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	

	<%@include file = "../includes/header.jsp" %>
	
			<a href="form.jsp"><button type="button" class="btn btn-primary">Crear Tarea Nueva</button></a>
	<%
	ListaTarea lt = new ListaTarea();
	out.print(lt.obtenerTareas());
	%>
	
	
	
	<%@include file = "../includes/footer.jsp" %>
</body>
</html>