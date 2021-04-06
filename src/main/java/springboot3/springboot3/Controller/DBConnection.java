package springboot3.springboot3.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    
    //javawebdb
    private static final String url = "jdbc:mysql://localhost:3306/javawebdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String dbconnect_login = "root";
    private static final String dbconnect_password = "";

    private static Connection dbconnect_connection;
    private static Statement dbconnect_statement;
    private static ResultSet dbconnect_result;
    private static int db_update_status;
    
     public static boolean unique_username_check(String user_login) throws SQLException, ClassNotFoundException{
     String checkquery = "select count(*) from users where username ='" + user_login + "'";
     
     System.out.println(checkquery);
     
     Class.forName("com.mysql.cj.jdbc.Driver");

      dbconnect_connection = DriverManager.getConnection(url, dbconnect_login, dbconnect_password);

      dbconnect_statement = dbconnect_connection.createStatement();

      dbconnect_result = dbconnect_statement.executeQuery(checkquery);

      while (dbconnect_result.next()) {
         int count = dbconnect_result.getInt(1);
         return count == 0;
            }
     
     return false;
     }
    
      public static boolean register(String user_login, String user_password) throws Exception{
      String reg_query = "INSERT INTO `users`(`username`, `password`) VALUES ('" + user_login +"','" +user_password+ "')";
      
      //System.out.println(reg_query); debug
      
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//important to JavaEE, but not for JavaSE and it kinda funny

            dbconnect_connection = DriverManager.getConnection(url, dbconnect_login, dbconnect_password);

            dbconnect_statement = dbconnect_connection.createStatement();

            db_update_status  = dbconnect_statement.executeUpdate(reg_query);

            
            
            
            
            
        } catch (SQLException sqlEx) {
        } 
        //No needs to eliminate the connection, the Apache can terminate itself
        /*finally {
            try { dbconnect_connection.close(); } catch(SQLException se) { System.out.println("Unexpected error, closing connection and check the logs");}
            try { dbconnect_statement.close(); } catch(SQLException se) { System.out.println("Unexpected error, closing connection and check the logs"); }
            try { dbconnect_result.close(); } catch(SQLException se) { System.out.println("Unexpected error, closing connection and check the logs"); }
        }*/
        return true;
    }
    
 
    public static boolean authorize(String user_login, String user_password) throws Exception{
     String loginquery = "select count(*) from users where username = " + "'" + user_login + "'" + " and password =" + "'" + user_password + "'";
     
     System.out.println(loginquery);

        try {
         Class.forName("com.mysql.cj.jdbc.Driver");//important to JavaEE, but not for JavaSE and it kinda funny

            
            dbconnect_connection = DriverManager.getConnection(url, dbconnect_login, dbconnect_password);

            dbconnect_statement = dbconnect_connection.createStatement();

            dbconnect_result = dbconnect_statement.executeQuery(loginquery);

            while (dbconnect_result.next()) {

                int count = dbconnect_result.getInt(1);
             return count == 1;
            }

        } catch (SQLException sqlEx) {
        } 
        return false;
    }
       
}
