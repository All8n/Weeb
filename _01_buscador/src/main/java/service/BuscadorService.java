package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Pagina;

public class BuscadorService {
	
	List<Pagina> paginas=List.of(new Pagina(new String[] {"libros","ocio","musica"},"www.fnac.es","Fnac","Todo el libros y juegos"),
			new Pagina(new String[] {"libros","musica"},"www.fmbook.es","My music","La mejor web para múscia y libros"),
			new Pagina(new String[] {"juegos","ocio"},"www.gamer.es","The game","El mundo del gamer"),
			new Pagina(new String[]{"juegos","merchandising"},"www.friky.es","Friky","Regalos originales")
			);
	
	//recibe la tematica y devuelve la lista de paginas asociadas a dicha tematica 
	
	public List<Pagina> tematicasPagina(String tema) {
		return paginas.stream()
				.filter(n->Arrays.stream(n.getTemas()).anyMatch(c->c.equals(tema)))
				.toList(); 	
	}
	
	//devuelve la lista de todos los temas registrados
	
	public List<String> temas(){
		
		return paginas.stream()
				.distinct()
				.flatMap(n->Arrays.stream(n.getTemas()))//Stream<String>
				.toList();
	}
	
}
