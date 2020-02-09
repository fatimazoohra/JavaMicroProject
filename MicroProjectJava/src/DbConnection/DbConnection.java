package DbConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DbConnection {

private static Connection conn;
	
	private DbConnection() { 
	}
	
	public static Connection getDbConnection()  {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cabinetmedical","root","");
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn; 
	}
}
