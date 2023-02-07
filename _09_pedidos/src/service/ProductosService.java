package service;

import java.util.List;

import model.Pedido;

public interface ProductosService {
	
	List<Pedido> pedidosTienda(String dirFichero);
	void guardarPedido(Pedido pedido);
	void guardarPedidos(List<Pedido> pedidos);

	
	
	
	
}