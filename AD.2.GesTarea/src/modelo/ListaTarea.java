package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOTarea;

public class ListaTarea {
	private ArrayList<Tarea> lista;
	
	
	
public ListaTarea() {
		super();
	}


public String obtenerTareasDependencia() {
	String info = "";
	try {
		lista = DAOTarea.getInstance().listaTareas();
	
	info="<div class=\"form-group\">\r\n" + 
			"		    <label for=\"text\">Depende de:</label>\r\n" + 
			"		    <select class=\"form-control\" name=\"dependencia\">\r\n" 
			+				"<option value=\"0\">Ninguna</option>";
								
					for (int i = 0; i < lista.size(); i++) {
						info += "<option value=\""+lista.get(i).getId()+"\">"+lista.get(i).getTitulo()+"</option>";
					}
			
			info += "		    </select>\r\n" + 
					"		  </div>";
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return info;
	
}

public String obtenerTareas(){
	
	String info = "";
		   info += "<table id=\"listaTareaTabla\" class=\"table\">\r\n" + 
		   		"	  <thead>\r\n" + 
		   		"	    <tr>\r\n" + 
		   		"	      <th scope=\"col\">ID</th>\r\n" + 
		   		"	      <th scope=\"col\">Titulo</th>\r\n" + 
		   		"	      <th scope=\"col\">Descripcion</th>\r\n" + 
		   		"	      <th scope=\"col\">Importante</th>\r\n" + 
		   		"	      <th scope=\"col\">FechaInicio</th>\r\n" + 
		   		"	      <th scope=\"col\">FechaFin</th>\r\n" + 
		   		"	      <th scope=\"col\">Categoria</th>\r\n" + 
		   		"	      <th scope=\"col\">Dependencia</th>\r\n" + 
		   		"	      <th scope=\"col\">Estado</th>\r\n" + 
		   		"	      <th scope=\"col\">Editar</th>\r\n" + 
		   		"	      <th scope=\"col\">Borrar</th>\r\n" + 
		   		"	    </tr>\r\n" + 
		   		"	  </thead>"
		   		+ "<tbody>";
	
		try {
			lista = DAOTarea.getInstance().listaTareas();
			
			for (int i = 0; i < lista.size(); i++) {
				info += lista.get(i).imprimeLista();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		info += "	</tbody>\r\n" + 
				"</table>";
		
		
		return info;
	}



}
