package principal;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.ItemsService;
import service.ItemsServiceFactory;

public class lanzador {
	
	public static void main(String[] args) {
		ItemsService service=ItemsServiceFactory.getPaisesService();
		List<String> paises=service.listaPaises();
		ExecutorService executor=Executors.newCachedThreadPool();
		CompletableFuture<Integer> future=CompletableFuture.supplyAsync(()->service.totalAcumulados(),executor);
		//definimos el codigo de respuesta que debe ser ejecutado cuando
		//la tarea finalice 
		future.whenCompleteAsync((r,e)->System.out.println("El total acumulado en europa es: "+r));
		//paises.forEach(p->System.out.println("Incidencia de "+p+"es: "+service.incidenciasPais(p)));
		//lanzamos el calculo de cada pais como tarea independiente
		paises.forEach(p->executor.submit(()->System.out.println("Incidencia de "+p+"es: "+service.incidenciasPais(p))));
		executor.shutdown();
	}
		
	

}
