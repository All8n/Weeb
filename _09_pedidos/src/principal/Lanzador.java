package principal;

import tareas.TareasTienda;

public class Lanzador {

	public static void main(String[] args) {
		
		TareasTienda t1=new TareasTienda("c:\\Ficheros\\tienda1.csv");
		TareasTienda t2=new TareasTienda("c:\\Ficheros\\tienda2.csv");
		TareasTienda t3=new TareasTienda("c:\\Ficheros\\tienda3.csv");
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

		System.out.println("tareas en proceso!");
	}

}
