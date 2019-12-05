package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOContacto;
import dao.DAOTarea;
import modelo.Contacto;
import modelo.Tarea;

/**
 * Servlet implementation class AltaTarea
 */
@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaTarea() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			
			
			if (request.getParameter("option")!= null && request.getParameter("option").equals("edit")) {
					response.sendRedirect("form.jsp?id="+request.getParameter("id"));
			} else if(request.getParameter("option")!= null && request.getParameter("option").equals("delete")){
					DAOTarea.getInstance().delete(request.getParameter("id"));
					response.sendRedirect("tareaList.jsp");
			}else if(request.getParameter("option")!= null && request.getParameter("option").equals("detalle")){
					response.sendRedirect("DetallesTarea.jsp?id="+request.getParameter("id"));
			}else {
				
				Tarea t = this.llenarTrabajo(request);
				
				if (request.getParameter("id").equals("0")) {
					System.out.println("insert");
					DAOTarea.getInstance().insert(t);
					response.sendRedirect("tareaList.jsp");
				}else {
					System.out.println("update");
					t.setId(Integer.parseInt(request.getParameter("id")));
					DAOTarea.getInstance().update(t);
					response.sendRedirect("tareaList.jsp");
				}
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Tarea llenarTrabajo(HttpServletRequest request) {
	

		Date fechaIni = new Date(this.parseDate(request.getParameter("fechaInicio")));
		Date fechaFin = new Date(this.parseDate(request.getParameter("fechaFin")));

		//System.out.println(request.getParameter("dependencia"));
		Tarea t = new Tarea(
				request.getParameter("titulo"), 
				request.getParameter("descripcion"),
				Integer.parseInt(request.getParameter("importante")), 
				fechaIni, 
				fechaFin,
				Integer.parseInt(request.getParameter("categoria")),
				Integer.parseInt(request.getParameter("dependencia")));
		return t;
	}
	
	private Long parseDate(String fechaString) {
		
		String fiyear = fechaString.substring(0, 4);
		String fimes = fechaString.substring(5, 7);
		String fidia = fechaString.substring(8, 10);

		Calendar auxCalIni = Calendar.getInstance();
		auxCalIni.set(Integer.parseInt(fiyear), Integer.parseInt(fimes) - 1, Integer.parseInt(fidia));
		long timeCal = auxCalIni.getTimeInMillis();
		return timeCal;
	}

}
