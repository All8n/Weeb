package presentacion.datamodel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Ciudad;
import service.CiudadesService;

public class AdaptadorTablaCiudades extends AbstractTableModel {
	
	List<Ciudad> ciudades;
	public AdaptadorTablaCiudades() {
			var service=new CiudadesService();
			ciudades=service.todas();
		}
	//total filas de la tabla

	@Override
	public int getRowCount() {
		return ciudades.size();
	}
	
	@Override
	public int getColumnCount() {
		//return 3;
		return Ciudad.class.getDeclaredFields().length;
	}

	@Override
	public String getColumnName(int column) {
		
		/*switch(column) {
		case 0:
			return "Nombre ciudad";
		case 1:
			return "Poblacion";
		case 2:
			return "Temperatura media";
		}
		return "";*/
		//desde java 17
		return switch(column) {
		case 0->"Nombre Ciudad";
		case 1->"Poblacion";
		case 2->"Temperatura media";
		default->"";

		};
	}
	
	//este metodo debe proporcionar el contenido de cada celda
	@Override
	public Object getValueAt(int row,int column) {
		return switch(column) {
		case 0->ciudades.get(row).getNombre();
		case 1->ciudades.get(row).getPoblacion();
		case 2->ciudades.get(row).getTemperatura();
		default -> throw new IllegalArgumentException("Unexpected value: " + column);
		//default->"";
		
		};
	}
	//proporciona el tipo de dato de cada columna 
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		/*return switch(columnIndex) {
			case 0->String.class;
			case 1->Integer.class;
			case 2->Double.class;
			default->null;
		};*/
		return Ciudad.class.getDeclaredFields()[columnIndex].getClass();
				
	}
	

}
