package tareas;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumaNumeros implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		//suma numeros del 1 al 100
		/*int suma=0;
		for(int i=0;i<100;i++) {
			suma+=i;
		}
		return suma;*/
		
		return IntStream.rangeClosed(1,100).sum();
	}

}
