package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestLectura {

	public static void main(String[] args) {
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		//Establecer conexión con base de datos
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			String sql="select * from contactos where nombre='profe'";
		
		}
		
		catch(SQLException ex) {
			ex.printStackTrace();
		}

}
}