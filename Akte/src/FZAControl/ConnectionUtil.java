package FZAControl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Util class, for database connections
 */
public class ConnectionUtil {
	
	private static Connection myConnection = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
		
		  Class.forName("com.mysql.jdbc.Driver");

	  
	      myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gruppe1?allowMultiQueries=true",
					"gruppe1admin", "");
	      
	      if (myConnection != null) {
//	          System.out.println("Connection erfolgreich aufgebaut!");
	      } else {
	          System.out.println("Connection konnte nicht aufgebaut werden!");
	          return null;
	         }
		
		return myConnection;
	}
	
	public static void close(final AutoCloseable obj) throws Exception {
		obj.close();
	}

}
