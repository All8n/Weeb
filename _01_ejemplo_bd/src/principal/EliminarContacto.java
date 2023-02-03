package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EliminarContacto {

	public static void main(String[] args) {
		//pide por teclado la introduccion de un nombre y elimina el contacto con dicho nombre
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del contacto que quieres eliminar:");
		String nombre=sc.nextLine();
		
		String cadenaCon="jdbc:mysql://localhost:3306/agenda";
		String user="root";
		String pwd="root";
		try(Connection con=DriverManager.getConnection(cadenaCon,user,pwd);){
			/*String sql="delete from contactos where nombre='"+nombre+"'";	
			Statement st=con.createStatement();
			st.execute(sql);
			*/
			//otra alternativa : instruccion SQL parametrizadas
			
			String sql="delete from contactos where nombre=?";//----------------------
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituir los parametros por sus valores
			ps.setString(1, nombre);
			//ejecucion de la consola
			ps.execute();//no se le da nada porque ya le dio el valor antes con el "?"^
			System.out.println("contacto eliminado!");
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
