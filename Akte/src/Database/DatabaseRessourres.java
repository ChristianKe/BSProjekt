package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import FZAControl.ConnectionUtil;
import GUIFZAApp.Fahrzeug;

public class DatabaseRessourres {
	
	
	
	public static String[] getTypesFromDatabase() {
		ArrayList<String> arrayList = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionUtil.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select id, typBezeichnung from allVehicleTypes");
			statement = connection.prepareStatement(sb.toString());
			resultSet = statement.executeQuery();

			arrayList = new ArrayList<>();
			arrayList.add("");
			while (resultSet.next()) {
				String string1 = resultSet.getString("typBezeichnung");
				arrayList.add(string1);
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrayList.toArray(new String[arrayList.size()]);
	}
	
	
	public static String[] getMarkenFromDatabase() {
		ArrayList<String> arrayList = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = ConnectionUtil.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from allVehicleBrands"); 
			statement = connection.prepareStatement(sb.toString());
			resultSet = statement.executeQuery();

			arrayList = new ArrayList<>();
			arrayList.add("");
			while (resultSet.next()) {
				String string2 = resultSet.getString("bezeichnung");
				arrayList.add(string2);
			}
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return arrayList.toArray(new String[arrayList.size()]);
		
	}
	
	
	public static String[] getModelFromDatabase(int markenId) {
		ArrayList<String> arrayList = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement statement = null;

		try {
			connection = ConnectionUtil.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select * from fahrzeugmodell ").append("where Fahrzeugmarke_id = ").append(markenId);
			statement = connection.prepareStatement(sb.toString());
			resultSet = statement.executeQuery();

			arrayList = new ArrayList<>();
			arrayList.add("");
			while (resultSet.next()) {
				String string3 = resultSet.getString("Bezeichnung");
				arrayList.add(string3);
			}

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		return arrayList.toArray(new String[arrayList.size()]);
	}
	
	public static ArrayList< Fahrzeug > getAllVehiclesFromDatabase( int limit ) throws SQLException, ClassNotFoundException, IOException
	{
	    ArrayList< Fahrzeug > list = new ArrayList<>();
	    
	    String sql = "";
	    if( 0 > limit )  // no limit
	    {
	        sql = "SELECT * FROM allVehicles";
	    }
	    else
	    {
	        sql = "SELECT * FROM allVehicles LIMIT " + limit;
	    }
	    
	    // database connection
        Connection connection;
        connection = ConnectionUtil.getConnection();

        // query vehicle data
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery( sql );
        
        while( rs.next() )
        {
            Fahrzeug fahrzeug = new Fahrzeug( rs.getString(1),
                                              rs.getString(2),
                                              rs.getInt(3),
                                              rs.getInt(4),
                                              rs.getString(5),
                                              rs.getString(6),
                                              rs.getString(7),
                                              rs.getString(8),
                                              rs.getString(9),
                                              rs.getString(10),
                                              rs.getString(11),
                                              rs.getString(12),
                                              rs.getString(13),
                                              rs.getString(14),
                                              rs.getString(15) );
            
            list.add( fahrzeug );
                                             
        }
        
	    return list;
	}
	


}
