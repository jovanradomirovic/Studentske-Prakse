/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;

import java.util.List;
import studentPractices.domain.Major;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author radom
 */
public class MajorRepository {
    
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
     
    public List<Major> getAll(){
        List<Major> smerovi = new LinkedList<>();
        String query = "SELECT * FROM smer";
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String ime = rs.getString("naziv");
                    Major smer = new Major(ID, ime);
                    smerovi.add(smer);
            }
            
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return smerovi;
    }
}
