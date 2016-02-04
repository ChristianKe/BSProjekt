package Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Database.DatabaseRessourres;
import Database.DatabaseStorage;

public class Test1 {

	String[] typenFromDatabase = null;
	String[] markenFromDatabase = null;
	String[] modellFromDatabase = null;
	
	@Test
	public void testGetTypesFromDatabase() {
		typenFromDatabase = DatabaseRessourres.getTypesFromDatabase();
		assertTrue("Test1", typenFromDatabase.length > 0);
		for (String vo : typenFromDatabase) {
			System.out.println(vo.toString());
		}
	}
	
	@Test
	public void testGetMarkenFromDatabase() {
		markenFromDatabase = DatabaseRessourres.getMarkenFromDatabase();
		assertTrue("Test2", markenFromDatabase.length > 0);
		for (String vo : markenFromDatabase) {
			System.out.println(vo.toString());
		}
	}
	
	@Test
	public void testGetModelFromDatabase() {
		modellFromDatabase = DatabaseRessourres.getModelFromDatabase(2);
		assertTrue("Test2", modellFromDatabase.length > 0);
		for (String vo : modellFromDatabase) {
			System.out.println(vo.toString());
		}
	}
	
	@Test
	public void testNewCustomer()
	{
		Map< Integer, String > input = new HashMap< Integer, String >();
		
		for( int i = 0; i < 17; ++i )
		{
			input.put( i, "5445" );
		}
		
		try {
			System.out.println( DatabaseStorage.storeNewVehicle( input ) );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
