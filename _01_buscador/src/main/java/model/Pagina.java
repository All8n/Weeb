package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Pagina {
	
	
	private String[] temas;
	private String url;
	private String titulo;
	private String descripcion;
		
	

}
