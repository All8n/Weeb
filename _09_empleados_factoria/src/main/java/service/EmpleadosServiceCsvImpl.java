package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Empleado;

public class EmpleadosServiceCsvImpl implements EmpleadosService{
	
		Path pt=Path.of("c:\\Ficheros\\empleados.csv");
			//método que reciba un empleado y lo guarde
		public void guardarEmpleado(Empleado empleado) {
			//tengo que construir una cadena de caracteres con los datos
			//del empleado, para poder guardarla en el fichero con la forma esperada
			String linea=empleado.getNombre()+","+empleado.getDepartamento()+","+empleado.getSalario()+","+empleado.getFecha();
			try {
				Files.writeString(pt,linea+System.lineSeparator(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	//metodo que devulva la lista de empleados de un determinado departamento
	public List<Empleado> empleadosDepartamento(String departamento){
		try {
			return Files.lines(pt)
			.map(s->{
				String[] datos=s.split("[,]");
				return new Empleado(datos[0],datos[1],Double.parseDouble(datos[2]),LocalDate.parse(datos[3]));
			})
			.filter(e->e.getDepartamento().equals(departamento))
			.toList();
			
		} catch (IOException e) {
			e.printStackTrace();
			return List.of();
		}
			
	}
	
	
	//metodo que devuelva una lista de departamentos
	
	public List<String> departamentos(){
		try {
			return Files.lines(pt)//Stream<String>
			.map(s->s.split("[,]")[1])//Stream<String>
			.distinct()
			.toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return List.of(); //devuelve lista vacía
		}
	}
	
	
}
