package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {
	
		String url="c:\\Ficheros\\empleados.json";
		Gson gson=new Gson();

		private Stream<Empleado> getJsonStream(){
		
		try(FileReader fr=new FileReader(url);){
		Empleado[]empleados=gson.fromJson(url, Empleado[].class);
		return Arrays.stream(empleados);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();//genera un stream vacio
		}
		}
			//método que reciba un empleado y lo guarde
		public void guardarEmpleado(Empleado empleado) {
			ArrayList<Empleado> lista=new ArrayList<>();
			 lista.add(empleado);
			 
			try (FileWriter fw=new FileWriter(url);){
				gson.toJson(lista,fw);

			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	
	//metodo que devulva la lista de empleados de un determinado departamento
	public List<Empleado> empleadosDepartamento(String departamento){
	 return  getJsonStream()
			.filter(e->e.getDepartamento().equals(departamento))
			.toList();
			
	}
	
	
	//metodo que devuelva una lista de departamentos
	
	public List<String> departamentos(){
    return   getJsonStream()
			.map(e->e.getDepartamento())	   
			.distinct()
			.toList();
			
	
	
}
}