	package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class EliminarServlet
 */
@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ContactosService service=ContactosServiceFactory.getContactosService();

		String nom=request.getParameter("nombre");
		
		service.eliminarContacto(nom);
		request.getRequestDispatcher("inicio.html").forward(request,response);

		
	}

}
