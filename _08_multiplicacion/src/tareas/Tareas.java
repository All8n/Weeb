package tareas;

public class Tareas implements Runnable{

	int num;
	
	public Tareas(int num) {
		this.num=num;
	}
	@Override
	public void run() {
	
		for(int i=1;i<=10;i++)  {
		 System.out.println(num+"x"+i+"="+num*i);
		 try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
