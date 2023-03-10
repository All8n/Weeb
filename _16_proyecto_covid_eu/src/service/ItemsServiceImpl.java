package service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import model.Item;
import service.locator.ItemsLocator;
import utilities.Utilidades;

public class ItemsServiceImpl implements ItemsService {
	//Desde una clase main, se mostrarán los datos de incidencia de todos paises registrados.
	//Así mismo, se lanzará una tarea encargada de calcular los casos totales y, una vez
	//completada, se mostrará ese resultado en consola
	
	ItemsLocator locator=new ItemsLocator();

	@Override
	public List<String> listaPaises() {
		return locator.getJsonStream()
				.map(it->it.getNombrePais())
				.distinct()
				.toList();
		
	}

	@Override
	public double incidenciasPais(String pais) {
		return locator.getJsonStream()
				.filter(it->it.getNombrePais().equals(pais)&&it.getIndicador().equals("cases")) //solo nos interesan los casos (no deaths) del pais
				.max((it1,it2)->Utilidades.convertirTextoFecha(it1.getFecha())
						.compareTo(Utilidades.convertirTextoFecha(it2.getFecha())))
				.orElse(new Item())
				.getIncidencia();
				
	
	}

	/*@Override
	public int totalAcumulados() {
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases"))
				.collect(Collectors.groupingBy(it->it.getNombrePais(),Collectors.maxBy((it1,it2)->Utilidades.convertirTextoFecha(it1.getFecha())
						.compareTo(Utilidades.convertirTextoFecha(it2.getFecha())))))//Map<String,Item>
						.values()//Collection<Item>
						.stream()//Stream<Item>
						.collect(Collectors.summingInt(op->op.get().getAcumulados()));
						
			}*/	
	@Override
	public int totalAcumulados() {
		LocalDate fechaMax=fechaMasReciente();
		return locator.getJsonStream()
				.filter(it->it.getIndicador().equals("cases")&&Utilidades.convertirTextoFecha(it.getFecha()).equals(fechaMax))
				.collect(Collectors.summingInt(it->it.getAcumulados()));
	}
				
	
		private LocalDate fechaMasReciente() {
			
			return locator.getJsonStream()
					.map(it->Utilidades.convertirTextoFecha(it.getFecha()))//Stream<LocalDate>
					.max((f1,f2)->f1.compareTo(f2))
					.orElse(LocalDate.now());
		}
						
			
	

}
