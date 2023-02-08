package service;

public class ProductosServiceFactory {
	
	public static ProductosService getContactosService() {
		return new ProductosServiceImpl();
	}


}
