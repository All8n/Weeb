package principal;

import tareas.Tareas;

public class Lanzador {

	public static void main(String[] args) {
		
		Tareas t1=new Tareas(4);
		Tareas t2=new Tareas(6);
		Tareas t3=new Tareas(9);
		
		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

}
}