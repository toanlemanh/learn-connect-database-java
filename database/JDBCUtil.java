package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection () {
		Connection c = null;
		try {
		
		com.mysql.jdbc.Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		String url = "jdbc:mySQL://127.0.0.1:3306/book_store_management";
		String user = "root";
		String pwd = "";
		c = DriverManager.getConnection(url,user,pwd);
		System.out.println("Connect to database successfully");
		}
		catch(SQLException sql) {
		   sql.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection (Connection c) {
		try {
			if (c != null)
				c.close();
			System.out.println("Connection is closed sucessfully");
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
