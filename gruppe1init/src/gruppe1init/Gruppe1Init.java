package gruppe1init;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

/*
 * Setup database and insert example data.
 */
public class Gruppe1Init
{
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException
	{
		/*
		 * Ask for db username and password
		 */
		System.out.print( "Username: " );
		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
		String username = bufferedReader.readLine();
		
		System.out.print( "Password: " );
		// TODO: mask password input
		String password = bufferedReader.readLine();
				
		/*
		 * Establish mysql connection
		 */
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbCon = (Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/?allowMultiQueries=true",
																	username,
																	password );
		
		/*
		 * open sql file and convert to String
		 */
		System.out.println( "Setting up database..." );
		bufferedReader = new BufferedReader( new FileReader( "SQLScript.sql" ) );
		StringBuilder stringBuilder = new StringBuilder();
	
		String line = "";
		while( null != ( line = bufferedReader.readLine() ) )
		{
			stringBuilder.append( line );
			stringBuilder.append( System.lineSeparator() );
		}
		
		String sql = stringBuilder.toString();
		bufferedReader.close();
		
		/*
		 * Set up database 'gruppe1'
		 */
		Statement statement = dbCon.createStatement();
		statement.execute( "DROP DATABASE IF EXISTS gruppe1;" );	// Drop complete database first
		statement.execute( sql );
		System.out.println( "Finished setting up database." );
		
		/*
		 * open insert data sql file
		 */
		System.out.println( "Inserting data..." );
		bufferedReader = new BufferedReader( new FileReader( "data.sql" ) );
		stringBuilder = new StringBuilder();

		line = "";
		while( null != ( line = bufferedReader.readLine() ) )
		{
			stringBuilder.append( line );
			stringBuilder.append( System.lineSeparator() );
		}
		
		String dataSql = stringBuilder.toString();
		bufferedReader.close();
		
		/*
		 * innsert data into database
		 */
		statement.execute( dataSql );
		System.out.println( "Finished inserting data." );
		
		/*
		 * Create new db user
		 */
		String newUser = "gruppe1admin";
		String sqlNewUser = "grant all on `gruppe1` to '" + newUser + "'@'localhost' identified by '';" +
							"FLUSH PRIVILEGES;";
		statement.execute( sqlNewUser );
		System.out.println( "Created user '" + newUser + "'" );
	}
}
