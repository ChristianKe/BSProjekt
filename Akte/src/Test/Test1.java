package Test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Ressources.DatabaseRessourres;

public class Test1 {

	String[] typenFromDatabase = null;
	String[] markenFromDatabase = null;
	
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
	


}
