package principal;

import service.ProductosService;
import service.ProductosServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		//de manera concurrente nos mostrara el total de unidades pedidas	
		//y el nombre del ultimo producto pedido
		new Thread(()->System.out.println(
				ProductosServiceFactory
				.getContactosService()
				.totalUnidades())).start();
		new Thread(()->System.out.println(
				ProductosServiceFactory
				.getContactosService()
				.productoUltimoPedido())).start();

	}

}
