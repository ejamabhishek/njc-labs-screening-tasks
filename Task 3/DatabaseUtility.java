import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseUtility {
    private final String MYSQL_URL  ;
    private final String DB_URL;
    private Connection dbConnection;
    private final String USER_NAME;
    private final String PASSWORD;
    private final String DATABASE_NAME  = "melbourne";

    public DatabaseUtility(){
        MYSQL_URL = "jdbc:mysql://localhost:3306";
        DB_URL = MYSQL_URL +"/" + DATABASE_NAME;
        //initialise MySql usename and password 
        USER_NAME ="root";
        PASSWORD = "";
        //sql query to create database.
        //dbCreateSQL = "CREATE DATABASE " + DATABASE_NAME ;
        //connect to Melbourne database
        //dbConnection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public void fetchAllSuburbs(){
      // Declaring prepared statement
        PreparedStatement suburbsRec; 
        try {
            if(dbConnection  == null)//connect to MySql ;
                dbConnection = DriverManager.getConnection (DB_URL, USER_NAME, PASSWORD);   
            // get the list of suburbs
            suburbsRec = dbConnection.prepareStatement("SELECT * FROM Suburbs");
            ResultSet rs = suburbsRec.executeQuery();
            
            // Loop through the records and display them
            while (rs.next()) {
                System.out.println(rs.getString("id")+" "+rs.getString("name")+" "+rs.getInt("postcode")+" "+rs.getString("locality")); 
            }
        }catch(SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
       }
    }
}