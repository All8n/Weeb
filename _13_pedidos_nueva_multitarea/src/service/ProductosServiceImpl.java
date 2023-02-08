package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import model.Pedido;
import service.locator.ConnectionLocator;

public class ProductosServiceImpl implements ProductosService {
	
	@Override 
	public List<Pedido>pedidosTienda(String dirFichero){
		Path pt=Path.of(dirFichero);
		try {
		return Files.lines(pt)//Stream<String>
		.map(n->{
			String[] datos=n.split(("[,]"));
			return new Pedido(0,datos[0],Integer.parseInt(datos[1]),LocalDate.parse(datos[2]));
		})
		.toList();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return List.of();
		}
	}
	@Override
	public void guardarPedido(Pedido pedido) {
		
		try(Connection con=ConnectionLocator.getConnection();){

		String sql="insert into pedidos(producto,unidades,fecha) values(?,?,?)";//-----
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, pedido.getProducto());
		ps.setInt(2, pedido.getUnidades());
		ps.setDate(3, Date.valueOf(pedido.getFecha()));
		ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();	
		}
		}
	
	@Override
	public void guardarPedidos(List<Pedido> pedidos) {	
		try(Connection con=ConnectionLocator.getConnection();){
			//desactivamos autocomm it para que todos los insert esten en la misma transaccion
			con.setAutoCommit(false);
			String sql="insert into pedidos(producto,unicades,fecha) values(?,?,?)";//-----
			PreparedStatement ps=con.prepareStatement(sql);
			for(Pedido p:pedidos) {
			ps.setString(1, p.getProducto());
			ps.setInt(2, p.getUnidades());
			ps.setDate(3, Date.valueOf(p.getFecha()));
			ps.execute();
			}
			con.commit();
		}
			catch(SQLException ex) {
				ex.printStackTrace();	
			}
			}
	@Override
	public int totalUnidades() {
		int total=0;
		try(Connection con=ConnectionLocator.getConnection();){
			//opcion 1
			
		/*String sql="select unicades from pedidos";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		//recorremos Resulset y sumamos todas las unidades
		while(rs.next()) {
			total+=rs.getInt("unicades");
		}*/
			//opcion 2: utilizar funciones de agregado
			
			String sql="select sum(unicades) from pedidos";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();//nos deplazamos a la primera y unica fila
			total=rs.getInt(1);//y le pedimos el valor 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public String productoUltimoPedido() {
		String resultado="";
		try(Connection con=ConnectionLocator.getConnection();){
			String sql="select producto from pedidos order by fecha DESC";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			rs.next();//nos deplazamos a la primera
			resultado=rs.getString("producto");
		
		
		}
		catch(SQLException ex) {
			ex.printStackTrace();	
		}
		return resultado;
		}
	
	
		

}
