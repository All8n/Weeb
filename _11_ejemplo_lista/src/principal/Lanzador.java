package principal;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import tareas.Ascendente;
import tareas.Descendente;

public class Lanzador {

	public static void main(String[] args) {
		
		//List<String> textos=new ArrayList<>();

		List<String> textos=new CopyOnWriteArrayList<>();
		Ascendente t1=new Ascendente(textos);
		Descendente t2=new Descendente(textos	);
		//se ponen en ejecucion concurrente
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//cuantas cadenas habra en la lista tras ejecutarse las dos tareas?
		System.out.println(textos.size());
	}
}