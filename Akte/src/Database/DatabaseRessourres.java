package Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import FZAControl.ConnectionUtil;

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
	
	
	


}
