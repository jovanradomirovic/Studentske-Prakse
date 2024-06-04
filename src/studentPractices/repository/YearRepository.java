/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Year;
/**
 *
 * @author petar
 */
public class YearRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
      public List<Year> getAll(){
        List<Year> years = new LinkedList<>();
        String query = "select * from skolska_godina";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int yearID = rs.getInt("godina");
                    Year year = new Year(yearID);
                    years.add(year);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return years;
    }
    
}
