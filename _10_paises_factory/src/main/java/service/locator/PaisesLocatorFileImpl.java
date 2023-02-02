package service.locator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisesLocatorFileImpl implements PaisesLocator {

	String url="c:\\Ficheros\\paises.json";
	Gson gson=new Gson();
	
	@Override
	public Stream<Pais> getJsonStream(){
		
		try(FileReader fr=new FileReader(url);){
			Pais[]paises=gson.fromJson(fr, Pais[].class);
			return Arrays.stream(paises);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}

	}
}
