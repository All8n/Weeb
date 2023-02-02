	package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.FormacionFactory;
import service.FormacionService;

/**
 * Servlet implementation class AlumnosServlet
 */
@WebServlet("/AlumnosServlet")
public class AlumnosServlet extends HttpServlet {
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//recoge el parametro que contiene el nombre de curso seleccionado ,despues
		//obtiene la lista de alumnos de ese curso, la guarda en un lugar accesible
		//para el JSP y transfiere el control a la pagina alumnos.jsp
		
	FormacionService service=FormacionFactory.getFormacionService();
	
	
	
	String nombreCurso=request.getParameter("curso");
	
	
	List<Alumno> alumnos=service.alumnoCurso(nombreCurso);
	
	double media=service.mediaDetCurso(nombreCurso);
	
	
	request.setAttribute("mediaCurso", media);
	
	request.setAttribute("alumnosCurso", alumnos);
	
	request.getRequestDispatcher("alumnos.jsp").forward(request, response);
	
	
	}

}
 