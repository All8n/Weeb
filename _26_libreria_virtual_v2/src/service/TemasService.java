package service;

import java.util.List;

import model.Libro;
import model.Temas;

public interface TemasService {
	List<Temas> temas();
	List<Libro> librosTemas(int idTema);


}
