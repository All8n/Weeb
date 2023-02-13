package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clientes {
	
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;
	
	

}
