package FZAControl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Handle login action.
 */
public class LogginControl{
	
	private static User user;
	
	public String getCurrentUserName() {
		return user.getName();
	}
	
	public static boolean login(String username, String password){
		ResultSet result = null;
		
		Connection connection;
		try {
			
			connection = ConnectionUtil.getConnection();
			String sql = "call checkLoginData(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString( 1, username );
			statement.setString( 2, password );
			
			result = statement.executeQuery();
			result.next();
			if ( 1 == result.getInt( 1 )) {	// TODO ???
				user = new User( result.getString( 2 ),
								 result.getString( 3 ),
								 username,
								 result.getBoolean(4),
								 result.getBoolean(5),
								 result.getBoolean(6));
				
				return true;
			}
		
		
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	/*
	 * return user object, of loged in user
	 */
	public static User getCurrentUser() {
		return user;
	}
}
