 
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisesService;


@WebServlet("/PaisesServlet")
public class PaisesServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaisesService service=new PaisesService();
		String continente=request.getParameter("continente");
		List<Pais> paises=service.paisesPorContinente(continente);
		request.setAttribute("paises", paises);
		//le mandamos también el nombre del continente seleccionado
		request.setAttribute("continente", continente);
		request.getRequestDispatcher("paises.jsp").forward(request, response);
	}
	
	}
	


