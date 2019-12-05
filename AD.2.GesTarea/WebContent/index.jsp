<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	
	<div id="heroContainer">
	
		<div id="hero">
			<h1>Administra tus tareas!</h1>
		</div>
		<div id="buttonContainer">
			<a href="tareaList.jsp"><button type="button" class="btn btn-default">Ver Tareas</button></a>
			<a href="form.jsp"><button type="button" class="btn btn-primary">Crear Tareas</button></a>
		</div>
	</div>
	
	
	
	
	<%@include file = "../includes/footer.jsp" %>
	
	
	
	

</body>
</html>