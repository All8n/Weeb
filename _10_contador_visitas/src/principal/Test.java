package principal;

import model.Contador;

public class Test {

	public static void main(String[] args) {
		//para probar el contador, creamos un objeto contador y tres tareas 
		
		
		Contador contador=new Contador();
		
		new Thread(()->contador.incrementar()).start();
		new Thread(()->contador.incrementar()).start();
		new Thread(()->contador.incrementar()).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(contador.getValor());
	}

}
