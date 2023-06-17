package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.*;// mySQL cung cấp jdbc api cho java 



public class JDBCclone {
	
// CREATE A CONNECTION BETWEEN JAVA APP AND DATABASE THROUGH JDBC DRIVER
//1.	REGISTER JDBC DRIVER WITH DRIVER MANAGER 
	public static Connection createConnection () {
		Connection c = null;
		try {

//		REGISTER A JDBC DRIVER
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		
//		PREPARE INPUTS OF CONNECTION LINK TO mySQL database
		String url = "jdbc:mySQL://localhost:3306/qlkh";
		String user = "root";
		String pwd = "";
		
//		RETURNING A CONNECTION FROM DRIVER MANAGER
		c = DriverManager.getConnection(url, user, pwd);
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			System.out.print("you've tried to connect to a database :");
		}
		return c;
	}
	
	public static void closeConnection (Connection c) {
		try {
			if ( c != null ) // avoid NullPointerException
				c.close();
			System.out.println("Connection is closed sucessfully");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
