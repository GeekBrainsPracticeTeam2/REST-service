
package database;

import java.sql.*;



public class DataBase {
   
    
    
    private static String url = "jdbc:mysql://localhost:3306/humaninweb"; 
    private static String user = "stat";
    private static String password = "stat";
    private static Connection c;
    private static Statement stmt;
    private static ResultSet rs;
    private static String query;
    
     public static void connectToBase(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(url, user, password);
        }
        
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
  
    public static void closeConnections(){
         if(c != null){
             try {
                c.close();
            }
             catch (SQLException se) {  
             se.printStackTrace();}
        }
    }
     
    public static void lastDate(){
        connectToBase();
        query = "select Date from Sites order by Date desc limit 1";
        try{
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                json.Json.objLastDate.put("lastdate", rs.getString("Date"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        closeConnections();
    }
    public static void sites(){
        json.Json.listSites.clear();
        connectToBase();
        query = "select id,Name,Date from Sites order by Date desc";
        try{
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                json.Json.listSites.add(rs.getString("id")+","+rs.getString("Name")+","+rs.getString("Date"));
            }
            json.Json.objSites.put("sites", json.Json.listSites);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        closeConnections();
    }
        public static void persons(){
        json.Json.listPersons.clear();
        connectToBase();
        query = "select id,Name from persons order by id desc";
        try{
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                json.Json.listPersons.add(rs.getString("id")+","+rs.getString("Name"));
            }
            json.Json.objPersons.put("persons", json.Json.listPersons);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        closeConnections();
    }
        public static void baseInsert(String name){
        connectToBase();
        query = "INSERT INTO Persons (Name) VALUES ('"+name+"');";
        try{
            stmt = c.createStatement();
            stmt.executeUpdate(query);
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        closeConnections();
    }
    
    
}
