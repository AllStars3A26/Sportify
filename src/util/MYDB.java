/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sahar Zouari
 */
public class MYDB {
        private final String url = "jdbc:mysql://localhost/sportify" ; 
    private final String user = "root" ; 
    private final String password = "" ; 
    private Connection cnx ; 
    static MYDB instance ; 
    
    
    private MYDB () {
        
        try { 
            cnx = DriverManager.getConnection(url, user, password) ;
            System.out.println("connnexion etablie");
        } catch (SQLException ex) {
           System.out.print(ex.getMessage()) ; 
        }
    }

    public static MYDB getInstance() {
        if  (instance== null) 
            instance = new MYDB () ; 
        return instance ; 
    }
    
    public Connection getConnection() {
        
        return cnx ;         
    }
}
