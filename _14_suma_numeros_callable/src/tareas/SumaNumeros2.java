package tareas;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SumaNumeros2 implements Supplier<Integer> {

	@Override
	public Integer get() {
		//suma numeros del 1 al 100
				int suma=0;
				for(int i=0;i<100;i++) {
					suma+=i;
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return suma;
				
			}

	}

