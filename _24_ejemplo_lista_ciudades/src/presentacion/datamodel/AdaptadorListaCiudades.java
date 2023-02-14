package presentacion.datamodel;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Ciudad;
import service.CiudadesService;

public class AdaptadorListaCiudades extends DefaultListModel<Ciudad>{
	
	List<Ciudad> ciudades;
	
	public AdaptadorListaCiudades() {
		
		//se conecta con la capa de negocios para obtener los datos originales que 
		//queremos mostrar en el JList
		CiudadesService service=new CiudadesService();
		ciudades=service.todas();
		
	}
	//sobreescribimos los metodos que van a ser llamados por el JList para 
	//rellenar su contenido

	@Override
	public int getSize() {
		//el tamaño del JList sera el tamaño de la lista de ciudades
		return ciudades.size();
	}

	@Override
	public Ciudad getElementAt(int index) {
		//en cada posicion del JList asignaremos la correspondiente posicion que tenemos en el list
		return ciudades.get(index);
	}
	

}
