<%@page import="dao.DAOTarea"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="modelo.Tarea"  %>
<%@page import="modelo.ListaTarea"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tareas Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<%
Tarea t = new Tarea();
int id = 0;
try{id = Integer.parseInt(request.getParameter("id"));
}catch(NullPointerException | NumberFormatException e){
}
if(id != 0 ){
	t = t.rellenarPorId(id);
}
%>

	
	 
		<%@include file = "../includes/header.jsp" %>
		<div id="containerForm">
		
		<form action="AltaTarea" method="post">
		
		<div class="form-group">
		    <input type="hidden" class="form-control" name="id" placeholder = "id" value=<%=t.getId()%>>
		  </div>
		  <div class="form-group">
		    <label for="text">Titulo:</label>
		    <input type="text" class="form-control" name="titulo" value=<%=t.getTitulo()  %>>
		  </div>
		  <div class="form-group">
		    <label for="text">Descripcion:</label>
		    <textarea class=form-control name="descripcion" ><%=t.getDescripcion()%></textarea>
		  </div>
		   <div class="form-group">
		    <label for="text">Importancia:</label>
		    <select class="form-control" name="importante">
		      <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="text">Categoria:</label>
		    <select class="form-control" name="categoria">
		      <option value="1">Programas y Procesos</option>
			  <option value="2">Desarrollo interfaces</option>
			  <option value="3">Acceso a Datos</option>
		    </select>
		  </div>
		  <div class="form-group">
		    <label for="Date">Fecha Inicio:</label>
		    <input type="date" class="form-control" name="fechaInicio" value=<%=t.getFechaInicio() %>>
		  </div>
		   <div class="form-group">
		    <label for="Date">Fecha Inicio:</label>
		    <input type="date" class="form-control" name="fechaFin" value=<%=t.getFechaFin()  %>>
		  </div>
		  <%
			ListaTarea lt = new ListaTarea();
			out.print(lt.obtenerTareasDependencia());
			%>
		  
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	  </div>
	  
	  <%@include file = "../includes/footer.jsp" %>
  
</body>
</html>