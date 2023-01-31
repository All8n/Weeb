package service;

import java.util.List;

import model.Pais;
import service.locator.PaisesLocator;

public class PaisesService {
	
	 PaisesLocator locator=new PaisesLocator();
	
	public List<Pais> paisesPorContinente(String continente){
		 return  locator.getJsonStream()
				.filter(e->e.getRegion().equals(continente))
				.toList();	
				
		}
	public List<String> continentes(){
	    return   locator.getJsonStream()	
				.map(e->e.getRegion())	   
				.distinct()
				.toList();
				
		
		
	}
}
