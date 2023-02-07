package tareas;

public class Ascendente implements Runnable {

	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println("ascendente: "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	
}
