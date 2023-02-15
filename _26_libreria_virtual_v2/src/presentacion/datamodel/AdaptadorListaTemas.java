package presentacion.datamodel;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Temas;
import service.LibreriaServiceFactory;
import service.TemasService;

public class AdaptadorListaTemas extends DefaultComboBoxModel<Temas>{
	
	List<Temas> temas;
	
	public AdaptadorListaTemas() {
		TemasService service=LibreriaServiceFactory.getTemasService();
		temas=service.temas();
		
	}

	@Override
	public int getSize() {
		return temas.size();
	}

	@Override
	public Temas getElementAt(int index) {
		return temas.get(index);
	}
	

}
