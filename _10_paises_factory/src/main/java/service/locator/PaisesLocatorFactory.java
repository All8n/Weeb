package service.locator;

public class PaisesLocatorFactory {

	public static PaisesLocator getPaisesLocator(){
		return new PaisesLocatorWebImpl();
	
}
}