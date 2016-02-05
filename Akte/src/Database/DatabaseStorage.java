package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;






import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import FZAControl.ConnectionUtil;

public class DatabaseStorage {
	
	private static final int ERROR_SQL_EXCEPTION	= 1;
	private static final int ERROR_INSERT_CUSTOMER	= 2;
	private static final int ERROR_INSERT_VEHICLE	= 3;

	public static int storeNewUser( Map< Integer, String > input )
	{
		
		
		
		return 0;
	}
	
	/*
	 * Create new customer and new vehicle
	 */
	public static int storeNewVehicle(Map<Integer, String> input) throws ClassNotFoundException, SQLException, IOException
	{
		
		/*
		 * get vehicle data from input map
		 */
		String	markeString			= input.get(1);
		int		marke				= Integer.parseInt( markeString );
		String	baujahr				= input.get(2);
		String	modellString		= input.get( 3 );
		int		modell				= Integer.parseInt( modellString );
		String	fahrzeugTypString	= input.get(4);
		int		fahrzeugTyp			= Integer.parseInt( fahrzeugTypString );
		String	kmStandString		= input.get(5);
		int		kmStand				= Integer.parseInt( kmStandString );
		String	leistungString		= input.get(6);
		int		leistung			= Integer.parseInt( leistungString );
	    String	kraftstoffString	= input.get( 7 );
	    int		kraftstoff			= Integer.parseInt( kraftstoffString );
		String	fahrgestellNummer	= input.get( 8 );
		String	kennzeichen			= input.get( 9 );
		
		/*
		 * get customer data from input map
		 */
		String kundenName		= input.get( 10 );
		String kundenVorname	= input.get( 11 );
		String kundenAdresse	= input.get( 12 );
		String kundenFirma		= input.get( 13 );
		String plz				= input.get( 14 );
		String ort				= input.get( 15 );
	
		// database connection
		Connection connection = ConnectionUtil.getConnection();
		Statement statement = connection.createStatement();
		
		/*
		 * disable foreign key constraints
		 */
		try
		{
			String sql = "SET FOREIGN_KEY_CHECKS=0";
			Statement stmt = connection.createStatement();
			stmt.execute( sql );
		}
		catch( SQLException e )
		{
			return ERROR_SQL_EXCEPTION;
		}

		/*
		 * Create new Customer, if not exists
		 */
		try
		{
			String sql = "CALL addCustomer( ?, ?, ?, ?, ?, ? )";
			PreparedStatement stmt = connection.prepareStatement( sql );
			stmt.setString( 1, kundenName );
			stmt.setString( 2, kundenVorname );
			stmt.setString( 3, ort );
			stmt.setString( 4, plz );
			stmt.setString( 5, kundenAdresse );
			stmt.setString( 6, kundenFirma );
			
			stmt.execute();
		}
		catch( MySQLIntegrityConstraintViolationException e )
		{
			// customer already exists in database
			// continue with adding a new vehicle			
		}
		catch( SQLException e )
		{
			return ERROR_SQL_EXCEPTION;
		}

		/*
		 * Get customer id
		 */
		int customerId = 0;
		try
		{
			ResultSet rs = null;
			String sql = "SELECT id FROM allCustomers WHERE Name='" + kundenName + "' AND Vorname='" + kundenVorname + "'";
			rs = statement.executeQuery( sql );
			
			if( rs.next() )
			{
				customerId = rs.getInt( 1 );
			}	
		}
		catch( SQLException e )
		{
			return ERROR_SQL_EXCEPTION;
		}
		
		/*
		 * Create new vehicle
		 */
		try
		{
			String sql = "CALL addVehicle( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			PreparedStatement stmt = connection.prepareStatement( sql );
			stmt.setString( 1, baujahr );
			stmt.setInt( 2, fahrzeugTyp );
			stmt.setString( 3, fahrgestellNummer );
			stmt.setInt( 4, customerId );
			stmt.setInt( 5, marke );
			stmt.setInt( 6, modell );
			stmt.setInt( 7, kmStand );
			stmt.setInt( 8, leistung );
			stmt.setInt( 9, kraftstoff );
			stmt.setString( 10, kennzeichen );
			
			stmt.execute();
		}
		catch( MySQLIntegrityConstraintViolationException e )
		{
			// vehicle already exists
			return ERROR_INSERT_VEHICLE;
		}
		catch( SQLException e )
		{
			return ERROR_SQL_EXCEPTION;
		}
		
		return 0;
	}

}
