package service;

public class LibreriaServiceFactory {
	
	public static ClientesService getClientesService() {
		return new ClientesServiceImpl();
	}
	public static LibrosService getLibrosService() {
		return new LibrosServiceImpl();
	}
	public static TemasService getTemasService() {
		return new TemasServiceImpl();
}
}
