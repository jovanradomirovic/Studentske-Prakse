/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentPractices.repository;
import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import studentPractices.domain.Module;
/**
 *
 * @author petar
 */
public class ModuleRepository {
    DatabaseConnection databaseConnection = new DatabaseConnection();
    
      public List<Module> getAll(){
        List<Module> modules = new LinkedList<>();
        String query = "select * from modul";
        
        
        try {
            databaseConnection.createConnection();
            Statement statement = databaseConnection.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String name = rs.getString("naziv");
                    int majorID = rs.getInt("smerID");
                    Module module = new Module( ID,  name,  majorID);
                    modules.add(module);
                }
            rs.close();
            statement.close();
            databaseConnection.connection.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return modules;
    }
}
