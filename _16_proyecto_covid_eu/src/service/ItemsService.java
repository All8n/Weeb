package service;

import java.util.List;

import model.Item;

public interface ItemsService {
	
	List<String> listaPaises();
	double incidenciasPais(String pais);
	int totalAcumulados();
}
