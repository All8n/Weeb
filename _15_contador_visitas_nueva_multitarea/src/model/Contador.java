package model;

public class Contador {

	private int valor;
	public void  incrementar() {
		int a=valor;
		a++;

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();

		}
		valor=a;

	}
	public void  decrementar() {
		synchronized(this) {
		int a=valor;
		a--;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
			
		} 	
		valor=a;
		} 
	}
	public int getValor() {
		return valor;
		
	}
}
