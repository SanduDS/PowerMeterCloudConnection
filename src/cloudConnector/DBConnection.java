/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cloudConnector;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {
    private static DBConnection dBConnection;
    private Connection conn;
    private String ipPort;
    private String database;
    private String user;
    private String pass;
    private DBConnection(String ipPort,String database,String user,String pass)throws SQLException,ClassNotFoundException{
        this.ipPort=ipPort;
        this.database=database;
        this.user=user;
        this.pass=pass;
        
        String hostName = ipPort;
        String dbName = database;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
        String password = pass;
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        
        conn = DriverManager.getConnection(url);

        
        
        
        
    }
    public static DBConnection getInstance(String ipPort,String database,String user,String pass) throws SQLException, ClassNotFoundException{
        if(dBConnection==null){
            dBConnection=new DBConnection(ipPort,database,user,pass);
        }
        return dBConnection;
    }
    public Connection getConnection(){
        return conn;
    }
    /*public static void main(String[] args){
        try {
            DBConnection bConnection=new DBConnection("ceb03.database.windows.net", "CEB","dhanushka","Sandu@2019");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
}
