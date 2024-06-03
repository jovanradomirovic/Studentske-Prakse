/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/**
 *
 * @author radom
 */
public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3306/studentske_prakse";
    private String user = "root";
    private String password = "";
    public Connection connection;
    
    public void createConnection(){
        
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Uspesno uspostavljena veza");
        } catch (SQLException ex) {
            System.out.println("Greska prilikom konekcije");
        }
        
    }
        
}
