package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import model.Empleado;

public class EmpleadosService {
	
	private Path pt=Path.of("c:\\ficheros\\empleados.csv");

	//metodo que reciba un empleado y lo guarda
	
	public void guardarEmpleado(Empleado empleado){
		//tengo que construir una cadena de caracteres de los datos
		//del empleado,para poder guardarla en elfichero con la forma esperada
			
		String linea=empleado.getNombre()+","+empleado.getDepartamento()+","+empleado.getSalario()+","+empleado.getFecha();
		
		try {
			Files.writeString(pt, linea+System.lineSeparator(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	//metodo que devulva la lista de empleados de un determinado departamento
	public List<Empleado> empleadosDepartamento(String departamento){
	
		
		
	}
	
	
	//metodo que devuelva una lista de departamentos
	
	public List<String> listaDepartamentos(){
		
		
	}
	
	
}
