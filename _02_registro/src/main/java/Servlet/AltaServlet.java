package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;
import service.ContactosServiceImpl;

/**
 * Servlet implementation class AltaServlet
 */
@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ContactosService service=ContactosServiceFactory.getContactosService();
	
	String nom=request.getParameter("nombre");
	String email=request.getParameter("email");
	int edad=Integer.parseInt(request.getParameter("edad"));
	
	Contacto contacto=new Contacto(0,nom,email,edad);
	service.agregarContacto(contacto);
	request.getRequestDispatcher("registro.html").forward(request,response);
	}

}
