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
    
    private static final int SUCCESS                   = 0;
    private static final int ERROR_EXCEPTION           = 1;
    private static final int ERROR_INSERT_CUSTOMER     = 2;
    private static final int ERROR_INSERT_VEHICLE      = 3;
    private static final int ERROR_WRONG_USER_NAME     = 4;
    
//  public static int updateUser( Map< Integer, String > input )
    public static int updateUser( String vorname,
                                  String nachname,
                                  String userName,
                                  String passwordOld,
                                  String password,
                                  int groupId )
    {
        // TODO> change map indices
//      String  vorname         = input.get(1);
//      String  nachname        = input.get(1);
//      String  userName        = input.get(1);
//      String  passwortOld     = input.get(1);
//      String  password        = input.get(1);
//      String  groupIdString   = input.get(1);
//      int     groupId         = Integer.parseInt( groupIdString );    
        
        
        
        return SUCCESS;
    }

//  public static int storeNewUser( Map< Integer, String > input )
    public static int storeNewUser( String vorname,
                                    String nachname,
                                    String userName,
                                    String password,
                                    int groupId )
    {
        // TODO: change map indices
//      String  vorname         = input.get(1);
//      String  nachname        = input.get(1);
//      String  userName        = input.get(1);
//      String  password        = input.get(1);
//      String  groupIdString   = input.get(1);
//      int     groupId         = Integer.parseInt( groupIdString );
        
        // database connection
        Connection connection;
        try
        {
            connection = ConnectionUtil.getConnection();
        }
        catch( ClassNotFoundException | SQLException | IOException e1 )
        {
            return ERROR_EXCEPTION;
        }
        
        try
        {
            String sql = "CALL addUser( ?, ?, ?, ?, ? )";
    
            PreparedStatement stmt = connection.prepareStatement( sql );
            stmt.setString( 1, userName );
            stmt.setString( 2, password );
            stmt.setString( 3, nachname );
            stmt.setString( 4, vorname );
            stmt.setInt( 5, groupId );
            
            stmt.execute();
        }
        catch( SQLException e1 )
        {
            return ERROR_EXCEPTION;
        }
        
        return SUCCESS;
    }
    
    /*
     * Create new customer and new vehicle
     */
    public static int storeNewVehicle( int markeId,
                                       String baujahr,
                                       int typId,
                                       int kmStand,
                                       int leistung,
                                       int kraftstoffId,
                                       int modellId,
                                       String fahrgestellnummer,
                                       String kennzeichen,
                                       String kundenName,
                                       String kundenVorname,
                                       String kundenAdresse,
                                       String kundenFirma,
                                       String plz,
                                       String ort )
//  public static int storeNewVehicle(Map<Integer, String> input)
    {
        
        /*
         * get vehicle data from input map
         */
//      String  markeString         = input.get(1);
//      int     marke               = Integer.parseInt( markeString );
//      String  baujahr             = input.get(2);
//      String  fahrzeugTypString   = input.get(3);
//      int     fahrzeugTyp         = Integer.parseInt( fahrzeugTypString );
//      String  kmStandString       = input.get(4);
//      int     kmStand             = Integer.parseInt( kmStandString );
//      String  leistungString      = input.get(5);
//      int     leistung            = Integer.parseInt( leistungString );
//      String  kraftstoffString    = input.get( 6 );
//      int     kraftstoff          = Integer.parseInt( kraftstoffString );
//      String  modellString        = input.get( 7 );
//      int     modell              = Integer.parseInt( modellString );
//      String  fahrgestellNummer   = input.get( 8 );
//      String  kennzeichen         = input.get( 9 );
        
        /*
         * get customer data from input map
         */
//      String kundenName       = input.get( 10 );
//      String kundenVorname    = input.get( 11 );
//      String kundenAdresse    = input.get( 12 );
//      String kundenFirma      = input.get( 13 );
//      String plz              = input.get( 14 );
//      String ort              = input.get( 15 );
    
        // database connection
        Connection connection;
        try
        {
            connection = ConnectionUtil.getConnection();
        }
        catch( ClassNotFoundException | SQLException | IOException e1 )
        {
            return ERROR_EXCEPTION;
        }
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
            return ERROR_EXCEPTION;
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
            return ERROR_EXCEPTION;
        }

        /*
         * Get customer id
         */
        int customerId = 0;
        try
        {
            ResultSet rs = null;
            Statement statement = connection.createStatement();
            String sql = "SELECT id FROM allCustomers WHERE Name='" + kundenName + "' AND Vorname='" + kundenVorname + "'";
            rs = statement.executeQuery( sql );
            
            if( rs.next() )
            {
                customerId = rs.getInt( 1 );
            }   
        }
        catch( SQLException e )
        {
            return ERROR_EXCEPTION;
        }
        
        /*
         * Create new vehicle
         */
        try
        {
            String sql = "CALL addVehicle( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            
            PreparedStatement stmt = connection.prepareStatement( sql );
            stmt.setString( 1, baujahr );
            stmt.setInt( 2, typId );
            stmt.setString( 3, fahrgestellnummer );
            stmt.setInt( 4, customerId );
            stmt.setInt( 5, markeId );
            stmt.setInt( 6, modellId );
            stmt.setInt( 7, kmStand );
            stmt.setInt( 8, leistung );
            stmt.setInt( 9, kraftstoffId );
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
            return ERROR_EXCEPTION;
        }
        
        return SUCCESS;
    }

}
