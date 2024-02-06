package DatabaseConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	Connection conn = null;

	public ConnectDB() {
	
	}
	
  public Connection connect() {
	
	try {
		
		// Load Driver;
		Class.forName("oracle.jdbc.OracleDriver");
		
		// Connect to database;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","123456789");
		
		System.out.println("Connected To Database");
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
  }
	
}
