package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Libro;
import model.Temas;
import service.locator.ConnectionLocator;

public class TemasServiceImpl implements TemasService {

	@Override
	public List<Temas> temas() {
		List<Temas> temas= new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from temas";
			PreparedStatement ps=con.prepareStatement(sql); 
			ResultSet rs=ps.executeQuery(); 
			while(rs.next()) {
				temas.add(new Temas(rs.getInt("idTema"), 
								    rs.getString("tematica")));
										
												
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return temas;

	}

	@Override
	public List<Libro> librosTemas(int idTema) {
		List<Libro> libros= new ArrayList<>();
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select * from libros where idTema=?";
			PreparedStatement ps=con.prepareStatement(sql); //Lanzar consultas a la base de datos
			ps.setInt(1, idTema);
			ResultSet rs=ps.executeQuery(); //forwardonly
			while(rs.next()) {
				libros.add(new Libro(rs.getInt("isbn"), 
										rs.getString("titulo"),
										rs.getString("autor"), 
										rs.getDouble("precio"),
										rs.getInt("paginas"),
										rs.getInt("idTema")));			
			}
			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return libros;
		}
	

}
