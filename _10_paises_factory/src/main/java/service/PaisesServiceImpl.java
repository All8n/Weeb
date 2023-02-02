package service;

import java.util.List;

import model.Pais;
import service.locator.PaisesLocator;
import service.locator.PaisesLocatorFactory;

public class PaisesServiceImpl implements PaisesService {
	
	 PaisesLocator locator=PaisesLocatorFactory.getPaisesLocator();
	
	@Override
	public List<Pais> paisesPorContinente(String continente){
		 return  locator.getJsonStream()
				.filter(e->e.getRegion().equals(continente))
				.toList();	
				
		}
	@Override
	public List<String> continentes(){
	    return   locator.getJsonStream()	
				.map(e->e.getRegion())	   
				.distinct()
				.toList();
				
		
		
	}
}
