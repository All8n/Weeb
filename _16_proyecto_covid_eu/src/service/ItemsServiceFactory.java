package service;

public class ItemsServiceFactory {
	
	public static ItemsService getPaisesService() {

	return new ItemsServiceImpl();
}
}