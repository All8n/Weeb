package principal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.ProductosServiceFactory;

public class Calculos {

	public static void main(String[] args) {
		
		ExecutorService executor=Executors.newCachedThreadPool();
		//de manera concurrente nos mostrara el total de unidades pedidas	
		//y el nombre del ultimo producto pedido
		executor.submit(()->System.out.println(
				ProductosServiceFactory
				.getContactosService()
				.totalUnidades()));
		executor.submit(()->System.out.println(
				ProductosServiceFactory
				.getContactosService()
				.productoUltimoPedido()));
		executor.shutdown();
	}

}
