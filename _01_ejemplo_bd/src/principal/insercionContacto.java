package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insercionContacto {

	public static void main(String[] args) {

		//paso 1: establecer la conexion con la BD
		
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		
		//establecer conexion con base de datos
		
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			//envio de instruccion SQL
			String sql="insert into contactos(nombre,email,edad) values('Irene','pruebas@gmail.com',19)";
			Statement  st=con.createStatement();//objeto para envio de instrucciones SQL
			st.execute(sql);//envio de instrucciones
			System.out.println("contacto añadido!");	
			//cerrar conexion

		}
		catch(SQLException ex) {
			ex.printStackTrace();	
		}
		
		}

}
