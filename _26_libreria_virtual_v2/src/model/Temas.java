package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Temas {
	
	private int idTema;
	private String tematica;
	
	@Override
	public String toString() {
		return tematica;
	}
}
