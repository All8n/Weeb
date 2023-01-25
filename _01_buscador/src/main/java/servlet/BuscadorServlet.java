package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;

//informa al servidor de aplicaciones que la clase es un servlet y tiene la direccion
//indicada	
@WebServlet("/BuscadorServlet")
public class BuscadorServlet extends HttpServlet {
	
	
	//sobreescritura del metodo service
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creamos un objeto de la capa de negocio 
		
		BuscadorService buscadorService=new BuscadorService();
		
		//recoge el parametro(datos enviados desde la pagina cliente)
		//que contiene el tema de busqueda
		
		String tema=request.getParameter("tema");
		
		//obtenemos lista de paginas de dicho tema 
		
		List<Pagina> paginas =buscadorService.tematicasPagina(tema);
		
		//guardamos la lista en un atributo de peticion para que pueda recogerlo la JSP
		
		request.setAttribute("paginas", paginas);
		
		//transferir el control a la pagina JSP
		
		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
	}
}
