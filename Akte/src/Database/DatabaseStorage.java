package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import FZAControl.ConnectionUtil;

public class DatabaseStorage {
	
	public static boolean storeNewVehicle(Map<Integer, String> input) {
		boolean result = false;
		
		String marke = input.get(1);
		String baujahr = input.get(2);
		String fahrzeugTyp = input.get(3);
		String kmStand = input.get(4);
		String leistung = input.get(5);
		String kraftstoff = input.get(6);
		String kraftstoff1 = input.get(7);
		String model = input.get(8);
		String fahrgetsellNummer = input.get(9);
		String kennzeichen = input.get(10);
		
		String kundenName = input.get(11);
		String kundenVorname = input.get(12);
		String kundenAdresse = input.get(13);
		String kundenFirma = input.get(14);
		String plz = input.get(15);
		String ort = input.get(16);

		
		try {
			/*
			 * Create new Customer
			 */
			//
			Connection connection = ConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			
			
			//
			StringBuilder sb = new StringBuilder();
			sb.append( "CALL addCustomer( '" + kundenName + "','" + kundenVorname +
					   "', '" + ort + "', '" + plz + "', '" + kundenAdresse +
					   "', '" + kundenFirma + "')" );
			result = statement.execute(sb.toString());
			
			/*
			 * 
			 */
			
		}
		catch( com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e )
		{
			// TODO: Customer already exists
		}
		catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		

		
		return result;
	}

}
