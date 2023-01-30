package principal;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import model.Curso;

public class Test {

	public static void main(String[] args) {
		
		String url="c:\\Ficheros\\cursos.json";
		
		//leer el contenido del fichero y mostrar los datos de todos los cursos
		
		
		try(FileReader fr=new FileReader(url);){
			
		Gson gson=new Gson();
		Curso[] cursos=gson.fromJson(fr,Curso[].class);
		
		for(Curso c:cursos) {
			System.out.println(c.getNombre()+"-"+c.getCurso()+"-"+c.getNota());
			
		  }
		
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
				
		
	}

}
