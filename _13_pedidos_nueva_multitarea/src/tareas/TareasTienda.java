package tareas;


import java.util.List;

import model.Pedido;
import service.ProductosService;
import service.ProductosServiceFactory;

public class TareasTienda implements Runnable {
	
	private String ruta;
	public TareasTienda(String ruta) {
		this.ruta=ruta;
	}

	@Override
	public void run() {
		ProductosService service=ProductosServiceFactory.getContactosService();
		//recupera los pedidos de la tienda
		List<Pedido> pedidos=service.pedidosTienda(ruta);
		//guarda los pedidos recuperados en la base de datos
		service.guardarPedidos(pedidos);
	}

}
