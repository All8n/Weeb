package tareas;

public class Ascendente extends Thread {

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
