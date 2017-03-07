
package database;

import java.sql.*;


public class DataBase {
    private static String url = "jdbc:mysql://"+"localhost"+":3306/"+"humaninweb"; 
    private static String user = "stat";
    private static String password = "stat";
    private static Connection c;
    private static Statement stmt;
    private static ResultSet rs;
    private static String query;
    
    public static void selectFromBase(String name, String site){
        //запрос в базу для получения значения(нет данных откуда запрашивать)
        query = "select * from Persons where name = '"+rest.Rest.namehuman+"'";
        
        try{
            c = DriverManager.getConnection(url, user, password);
            stmt = c.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
        //добавление в объект json 
       json.Json.objPerson.put("name", rest.Rest.namehuman);
       json.Json.objPerson.put("site", rest.Rest.sitedest);
       json.Json.objPerson.put("freq", "Сколько раз имя встретилось на сайте");
            }
        }
        catch(SQLException sqlEx){
            sqlEx.printStackTrace();
            
        }
        finally{
                try {
                c.close();
            } catch (SQLException se) { 
            }
            try {
                stmt.close();
            } catch (SQLException se) {  
            }
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }
}
