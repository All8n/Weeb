package principal;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Curso;

public class TestEscritura {

	public static void main(String[] args) {

		String url="c:\\Ficheros\\cursos.json";

		Curso curso=new Curso("al4","JavaScript",6.7);
		//recuperamos el JSON completo. Añadimos el objeto, y después
		//escribimos todo el contenido de nuevo
		ArrayList<Curso> lista;
		Gson gson=new Gson();
		try(
			FileReader fr=new FileReader(url);){		
			Curso[] cursos=gson.fromJson(fr,Curso[].class);
			//esta instrucción crea un ArrayList a partir de un array
			lista=new ArrayList<>(List.of(cursos));
			//añadimos el nuevo curso
			lista.add(curso);			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return;
		}
		
		try(FileWriter fw=new FileWriter(url);){//modo sobrescritura
			//y escribimos en el fichero la lista entera
			gson.toJson(lista, fw);
			System.out.println("curso guardado!");
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}