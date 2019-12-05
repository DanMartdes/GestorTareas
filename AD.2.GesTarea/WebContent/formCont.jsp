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
		<div id="containerForm">
		
		<form action="AltaContacto" method="post">
		  <div class="form-group">
		    <label for="text">Nombre:</label>
		    <input type="text" class="form-control" name="nombre">
		  </div>
		  <div class="form-group">
		    <label for="text">Apellido:</label>
		    <input type="text" class="form-control" name="apellido">
		  </div>
		  <div class="form-group">
		    <label for="email">Correo:</label>
		    <input type="email" class="form-control" name="correo">
		  </div>
		  <div class="form-group">
		    <label for="tel">Numero:</label>
		    <input type="tel" class="form-control" name="telefono">
		  </div>
		  
		  
		  <a href = "" ></a>
		  
		  
		  
		  <div class="checkbox">
		    <label><input type="checkbox"> Remember me</label>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	  </div>
	  
	  <%@include file = "../includes/footer.jsp" %>

</body>
</html>