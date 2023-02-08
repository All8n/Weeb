package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TareasTienda;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();

		TareasTienda t1=new TareasTienda("c:\\Ficheros\\tienda1.csv");
		TareasTienda t2=new TareasTienda("c:\\Ficheros\\tienda2.csv");
		TareasTienda t3=new TareasTienda("c:\\Ficheros\\tienda3.csv");
		
		executor.submit(t1);
		executor.submit(t2);
		executor.submit(t3);

		System.out.println("tareas en proceso!");
		executor.shutdown();
	}	

}
