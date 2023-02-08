package principal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();

		Ascendente t1=new Ascendente();
		Descendente t2=new Descendente();
		//se ponen en ejecucion concurrente
		
		executor.submit(t1);
		executor.submit(t2);


		for(int i=1;i<=100;i++) {
			System.out.println("haciendo cosas en el main....");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}
}