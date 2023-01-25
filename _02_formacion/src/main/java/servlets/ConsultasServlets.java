package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FormacionService;

@WebServlet("/ConsultasServlets")
public class ConsultasServlets extends HttpServlet {
	
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//debe recoger la lista de nombres de cursos, guardarla en algun
		//lugar que sea accesible para el JSP, y despues transferir el control
		//a la pagina seleccion.jsp
		FormacionService service=new FormacionService();
	
	
		List<String> nombre=service.cursos();
				
		request.setAttribute("nombresCursos", nombre);
		
		request.getRequestDispatcher("seleccion.jsp").forward(request, response);
	}

}
