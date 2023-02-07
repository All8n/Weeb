package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {
	
	private int idPedidos;
	private String producto;
	private int unidades;
	private LocalDate fecha;

}
