/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.City;

/**
 *
 * @author petar
 */
public class CityRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
      public List<City> getAll(){
        List<City> cities = new LinkedList<>();
        String query = "select * from mesto";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int postalCode = rs.getInt("PID");
                    String name = rs.getString("naziv");
                    City city = new City(postalCode, name);
                    cities.add(city);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return cities;
    }
}
